package by.silebin.information_handling.interpreter;

public class ExpressionComplement implements MathExpression {
    @Override
    public void interpret(Context context) {
        context.push(~context.pop());
    }
}
