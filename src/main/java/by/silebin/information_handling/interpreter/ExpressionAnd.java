package by.silebin.information_handling.interpreter;

public class ExpressionAnd implements  MathExpression{

    @Override
    public void interpret(Context context) {
        context.push(context.pop() & context.pop());
    }
}
