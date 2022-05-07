public class TreeCalculator {

    protected TreeNode node;

    /**
     * generate an expression tree from a postfix expression and evaluate it using evaluateExpression method.
     * @param expr the postfix expression.
     * @return - the value of the expression tree's calculate result.
     */

    public double evaluate(String expr) {
        ExpressionTree evaluate_tree = new ExpressionTree();
        evaluate_tree.BuildExpressionTree(expr);
        node = evaluate_tree.tree_root;
        //rote node instead evaluate_tree.tree_root
        return evaluateExpression(node);
    }

    /**
     * evaluate the result of an expression tree.
     * @param node the root node of an expression tree.
     * @return - the value of the expression tree's calculate result.
     */

    private double evaluateExpression(TreeNode node) {

        double result;
        if (node.getData() instanceof BinaryOp) {
            double operand1 = evaluateExpression(node.getLeft());
            double operand2 = evaluateExpression(node.getRight());
            result = ((BinaryOp) node.getData()).operate(operand1, operand2);
        } else
            result = ((ValueToken) node.getData()).getValue();
        return result;
    }

    /** shell function that using recursiveGetInfix method in order to calculate infix expression.
     * @return - the infix expression without open and close brackets of the expression's edge
     */

    public String getInfix() {
        // add the if in case there is only one node.
        // without the if statement, in case of one node and using the substring, the value return will cut the first number
        // for example, without the if, one node with value of 13 return 3
        if ((node.isLeaf()))
            return recursiveGetInfix(node);
        String infix_expression = recursiveGetInfix(node);
        return infix_expression.substring(1,infix_expression.length()-1);
    }

    /** calculate the infix format of an expression tree using recursion.
     * @return - the infix expression that contains open and close brackets of the expression's edge.
     */

    private String recursiveGetInfix(TreeNode node) {

        if (node != null) {
            String left = recursiveGetInfix(node.getLeft());
            String str = node.getData().toString();
            String right = recursiveGetInfix(node.getRight());
            if (node.isLeaf()) {
                return str;
            }
            return "("+ left + " " + str + " " + right + ")";
        }
        return "";
    }

    /** shell function that using recursiveGetPostfix method in order to calculate postfix expression.
     * @return - the postfix expression without an unnecessary space exists at return String's last character.
     */

    public String getPostfix() {
        if ((node.isLeaf()))
            return recursiveGetPostfix(node).substring(0,recursiveGetPostfix(node).length()-1);
        String postfix_expression = recursiveGetPostfix(node);
        return postfix_expression.substring(0,postfix_expression.length()-1);
    }

    /** calculate the postfix format of an expression tree using recursion.
     * @return - the postfix expression that contains an unnecessary space exists at the return String's last character.
     */

    private String recursiveGetPostfix(TreeNode node) {

        if (node != null) {
            String left = recursiveGetPostfix(node.getLeft());
            String right = recursiveGetPostfix(node.getRight());
            String str = node.getData().toString() + " ";
            return left + right + str;
        }
        return "";
    }

    /** shell function that using recursiveGetPrefix method in order to calculate prefix expression.
     * @return - the prefix expression without an unnecessary space exists at the return String's last character.
     */

    public String getPrefix() {
        if ((node.isLeaf()))
            return recursiveGetPrefix(node).substring(0,recursiveGetPrefix(node).length()-1);
        String prefix_expression = recursiveGetPrefix(node);
        // without using the substring, the prefix output contains unnecessary space at the end of the string
        // for example return "+ - * 6.0 2.0 * 4.0 3.0 " instead of "+ - * 6.0 2.0 * 4.0 3.0"
        // So the substring cut the last space
        return prefix_expression.substring(0,prefix_expression.length()-1);
    }

    /** calculate the prefix format of an expression tree using recursion.
     * @return - the prefix expression that contains an unnecessary space exists at the return String's last character.
     */

    private String recursiveGetPrefix(TreeNode node) {

        if (node != null) {
            String str = node.getData().toString()+" ";
            String left = recursiveGetPrefix(node.getLeft());
            String right = recursiveGetPrefix(node.getRight());
            return str + left + right;
        }
        return "";
    }
}








