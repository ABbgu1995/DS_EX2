public class DivideOp extends BinaryOp {
    @Override
    public double getPrecedence() {
        return 1;
    }

    @Override
    // divide by zero case
    public double operate(double left, double right) {
        return left / right;

    }

    @Override
    public String toString() {
        return "/";
    }
}
