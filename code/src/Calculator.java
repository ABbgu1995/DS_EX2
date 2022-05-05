/**
 * Abstract "superclass" describing ALL calculators seen when calculate
 * arithmetic expressions.
 */
public abstract class Calculator {
    /**
     * By making this method abstract, all subclasses MUST implement it.
     * @return the value of the expr.
     */
    public abstract double evaluate(String expr);
}
