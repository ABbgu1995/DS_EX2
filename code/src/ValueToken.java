import com.sun.jdi.Value;

public class ValueToken extends CalcToken {
    private double val;
    public ValueToken (double val){
            this.val=val;
    }
     public double getValue(){
        return this.val;
     }

    @Override
    public String toString() {
        // Check another casting option
        return String.valueOf(val);
    }
}//amit
