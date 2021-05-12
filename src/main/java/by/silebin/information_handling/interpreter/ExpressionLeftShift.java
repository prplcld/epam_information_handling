package by.silebin.information_handling.interpreter;

public class ExpressionLeftShift implements MathExpression {
    @Override
    public void interpret(Context context) {
        int firstOperand = context.pop();
        int secondOperand = context.pop();
        context.push(secondOperand << firstOperand);
    }
}
