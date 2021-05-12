package by.silebin.information_handling.interpreter;

public class ExpressionNumber implements MathExpression {

    private int number;

    public ExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.push(number);
    }
}
