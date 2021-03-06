public class ExpressionTree {
    protected TreeNode tree_root;

    /**
     * Build an expression tree based on postfix expression from the tree_root as the root of the expression tree
     * @param postfixExp postfix format of an expression
     */
    public void BuildExpressionTree (String postfixExp){
        ExpTokenizer tokens = new ExpTokenizer(postfixExp);
        StackAsArray primary_stack= new StackAsArray();
        while(tokens.hasMoreElements()){
            Object iteration_token = tokens.nextElement();
            if(iteration_token instanceof ValueToken){
                TreeNode new_leaf = new TreeNode(iteration_token);
                primary_stack.push(new_leaf);
            }
            else if (iteration_token instanceof BinaryOp){
                TreeNode right_node = (TreeNode) primary_stack.pop();
                TreeNode left_node = (TreeNode) primary_stack.pop();
                TreeNode full_node = new TreeNode(iteration_token,left_node,right_node);
                primary_stack.push(full_node);
            }
        }
        tree_root = (TreeNode) primary_stack.pop();
    }
}
