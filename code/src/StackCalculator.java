public class StackCalculator extends Calculator {


    public String infixToPostfix(String expr){
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
                        && (((BinaryOp) iteration_token).getPrecedence() >=
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
        ExpTokenizer e_t_post=new ExpTokenizer(expr);
        StackAsArray st2=new StackAsArray();
        while (e_t_post.hasMoreElements()){
            Object iter_token_2=e_t_post.nextElement();
            if (iter_token_2 instanceof BinaryOp){
                double right=((ValueToken)(st2.pop())).getValue();
                double left=((ValueToken)(st2.pop())).getValue();
                ValueToken result = new ValueToken(((BinaryOp) iter_token_2).operate(left,right));
                st2.push(result);
            }
            else
                st2.push(iter_token_2);

        }
        return ((ValueToken)st2.pop()).getValue();
    }

}
