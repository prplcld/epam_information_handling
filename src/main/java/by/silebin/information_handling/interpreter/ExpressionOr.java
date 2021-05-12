package by.silebin.information_handling.interpreter;

public class ExpressionOr implements MathExpression {
    @Override
    public void interpret(Context context) {
        context.push(context.pop()| context.pop());
    }
}
