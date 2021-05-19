package by.silebin.information_handling.util;

import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixConverter {

    private static final String operations = "~><&^|()";

    public static String convert(String expression) {
        expression = expression.replace(">>", ">").replace("<<", "<");;

        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        StringTokenizer stringTokenizer = new StringTokenizer(expression, "><&^~()|", true);

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if(operations.contains(token)) {
                if (token.equals("(")) {
                    stack.push(token);
                }
                else if (token.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        result.append(stack.pop());
                        result.append(" ");
                    }
                    stack.pop();
                }
                else {
                    while (!stack.empty() && priority(stack.peek()) >= priority(token)) {
                        result.append(stack.pop());
                        result.append(" ");
                    }
                    stack.push(token);
                }
            }
            else {
                result.append(token);
                result.append(" ");
            }
        }

        while (!stack.empty()) {
            result.append(stack.pop());
            result.append(" ");
        }

        return result.toString();
    }

    private static int priority(String a) {
        switch (a){
            case "~" : return 6;
            case ">":
            case "<": return 5;
            case "&": return 4;
            case "^": return 3;
            case "|": return 2;
            case "(": return 1;
        }
        return 0;
    }
}
