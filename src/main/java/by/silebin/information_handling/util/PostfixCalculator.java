package by.silebin.information_handling.util;

import by.silebin.information_handling.exception.PostfixCalculatorException;
import by.silebin.information_handling.interpreter.*;

import java.util.ArrayList;
import java.util.List;

public class PostfixCalculator {
    private List<MathExpression> expressions;

    public void parseExpression(String expression) {
        expressions = new ArrayList<>();
        for (String s : expression.split(" ")) {
            switch (s) {
                case "&":
                    expressions.add(c -> c.push(c.pop() & c.pop()));
                    break;
                case "|":
                    expressions.add(c -> c.push(c.pop() | c.pop()));
                    break;
                case "^":
                    expressions.add(c -> c.push(c.pop() ^ c.pop()));
                    break;
                case ">":
                    expressions.add(c -> {
                        int firstOperand = c.pop();
                        int secondOperand = c.pop();
                        c.push(secondOperand >> firstOperand);
                    });
                    break;
                case "<":
                    expressions.add(c -> {
                        int firstOperand = c.pop();
                        int secondOperand = c.pop();
                        c.push(secondOperand << firstOperand);
                    });
                    break;
                case "~":
                    expressions.add(c -> c.push(~c.pop()));
                    break;
                default:
                    expressions.add(c -> c.push(Integer.parseInt(s)));
                    break;
            }
        }
    }

    public int calculate() throws PostfixCalculatorException {
        if (expressions.isEmpty()) {
            throw new PostfixCalculatorException("no expression presented for calculating");
        }
        Context context = new Context();
        for (MathExpression expression : expressions) {
            expression.interpret(context);
        }
        expressions.clear();
        return context.pop();
    }
}
