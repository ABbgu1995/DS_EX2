public class DivideOp extends BinaryOp {

    private double left;
    private double right;

    /**
     * operate-calculate the value of the operation.
     * @param left the left operand.
     * @param right the right operand.
     * @return - the value of the operation.
     */

    @Override
    public double operate(double left, double right) {
        return left / right;
    }

    @Override
    /**
     * getPrecedence-represent the precedence of the operation
     * @return - the precedence of the operation
     */
    public double getPrecedence() {
        return 1;
    }

    @Override
    /**
     * toString-Override CalcToken.
     * @return - the mathematical symbol of the operation.
     */
    public String toString() {
        return "/";
    }
    }