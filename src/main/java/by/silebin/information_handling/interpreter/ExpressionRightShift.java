package by.silebin.information_handling.interpreter;

public class ExpressionRightShift implements MathExpression {
    @Override
    public void interpret(Context context) {
        int firstOperand = context.pop();
        int secondOperand = context.pop();
        context.push(secondOperand >> firstOperand);
    }
}
