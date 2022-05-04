public class StackCalculator extends Calculator {


    public static String infixToPostfix(String expr){
        // receives a valid infix expression, and returns a valid postfix expression
        // infix to postfix converter
        ExpTokenizer tokens = new ExpTokenizer(expr);
        String postfix_str="";
        StackAsArray primary_stack = new StackAsArray();
        while(tokens.hasMoreElements()){
            // CalcToken iteration_token = tokens.nextElement();
            Object iteration_token = tokens.nextElement();
            if (iteration_token instanceof OpenBracket){
                primary_stack.push(new OpenBracket());
            }
            else if (iteration_token instanceof CloseBracket){
                while(!(primary_stack.elements[primary_stack.size-1] instanceof OpenBracket)){
                    postfix_str = postfix_str + " " + (primary_stack.pop().toString());
                }
                primary_stack.pop();
            }
            else if(iteration_token instanceof BinaryOp){
                while(
                        (!(primary_stack.isEmpty()) && (primary_stack.elements[primary_stack.size-1] instanceof BinaryOp)
                        && (((BinaryOp) iteration_token).getPrecedence() <
                        ((BinaryOp) primary_stack.elements[primary_stack.size-1]).getPrecedence()))
                )
                {
                    postfix_str=postfix_str + " " + (primary_stack.pop().toString());
                }
                primary_stack.push(iteration_token);
            }
            else if (iteration_token instanceof ValueToken){
                postfix_str=postfix_str + " " + iteration_token.toString();

            }
        }
        while (!primary_stack.isEmpty()){
            postfix_str=postfix_str + " " + (primary_stack.pop().toString());
        }
        return postfix_str.substring(1,postfix_str.length());

    }
    @Override
    public double evaluate(String expr) {
        // expr Postfix format: "7 3 + 18 2"
        return 0;
    }
}
