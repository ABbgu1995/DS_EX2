public class AddOp extends BinaryOp {
    @Override
    public double getPrecedence() {
        return 2;
    }

    @Override
    public double operate(double left, double right) {
        return left + right;

    }

    @Override
    public String toString() {
        return "+";
    }
}
