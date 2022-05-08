public class ValueToken extends CalcToken {
    private double val;
    /**
     * constructor for ValueToken class.
     * @param val the numeric value of the ValueToken object.
     */
    public ValueToken (double val){
            this.val=val;
    }

    /**
     * return the val parameter value of the current object the method call from.
     */
    public double getValue(){
        return this.val;
     }

    /**
     * return the val parameter value as a String
     */
    @Override
    public String toString() {
        // Check another casting option
        return String.valueOf(val);
    }
}
