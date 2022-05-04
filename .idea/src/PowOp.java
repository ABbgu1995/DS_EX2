public class PowOp extends BinaryOp {
    @Override
    public double getPrecedence()
    {
        return 0;
    }

    @Override
    public double operate(double left, double right) {
        double result = left;
        for (int i = 1; i < right; i++) {
            result *= left;
        }
        return result;
    }

    @Override
    public String toString() {
        return "^";
    }
}
