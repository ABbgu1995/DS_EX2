/**
 * extends BinaryOp
 */
public class SubtractOp extends BinaryOp {
    /**
     * getPrecedence-represent the precedence of the operation
     * @return - the precedence of the operation
     */
    @Override
    public double getPrecedence() {
        return 0;
    }
    /**
     * operate-calculate the value of the operation.
     * @param left the left operand.
     * @param right the right operand.
     * @return - the value of the operation.
     */
    @Override
    public double operate(double left, double right) {
        return left - right;

    }

    /**
     * toString-Override CalcToken.
     * @return - the mathematical symbol of the operation.
     */
    @Override

    public String toString() {
        return "-";
    }
}
