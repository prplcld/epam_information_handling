package by.silebin.information_handling.util;

import by.silebin.information_handling.interpreter.*;

import java.util.ArrayList;
import java.util.List;

public class PostfixCalculator {
    private List<MathExpression> expressions;

    public PostfixCalculator (String expression) {
        expressions = new ArrayList<>();
        parseExpression(expression);
    }

    private void parseExpression(String expression) {
        for (String s : expression.split(" ")) {
            switch (s) {
                case "&":
                    expressions.add(new ExpressionAnd());
                    break;
                case "|":
                    expressions.add(new ExpressionOr());
                    break;
                case "^":
                    expressions.add(new ExpressionXor());
                    break;
                case ">":
                    expressions.add(new ExpressionRightShift());
                    break;
                case "<":
                    expressions.add(new ExpressionLeftShift());
                    break;
                case "~":
                    expressions.add(new ExpressionComplement());
                    break;
                default:
                    expressions.add(new ExpressionNumber(Integer.parseInt(s)));
                    break;
            }
        }
    }

    public int calculate() {
        Context context = new Context();
        for (MathExpression expression : expressions) {
            expression.interpret(context);
        }
        return context.pop();
    }
}
