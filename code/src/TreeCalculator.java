public class TreeCalculator {

    protected TreeNode node;


    public double evaluate(String expr) {
        ExpressionTree evaluate_tree = new ExpressionTree();
        evaluate_tree.BuildExpressionTree(expr);
        node = evaluate_tree.tree_root;
        return evaluateExpression(evaluate_tree.tree_root);
    }

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

    public String getInfix() {
        // add the if in case there is only one node.
        // without the if statement, in case of one node and using the substring, the value return will cut the first number
        // for example, without the if, one node with value of 13 return 3
        if ((node.isLeaf()))
            return recursiveGetInfix(node);
        String winner = recursiveGetInfix(node);
        return winner.substring(1,winner.length()-1);

    }

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
    public String getPostfix() {
        return recursiveGetPostfix(node);


    }

    private String recursiveGetPostfix(TreeNode node) {

        if (node != null) {
            String left = recursiveGetPostfix(node.getLeft());
            String right = recursiveGetPostfix(node.getRight());
            String str = node.getData().toString() + " ";
            return left + right + str;

        }
        return "";
    }
    public String getPrefix() {
        return recursiveGetPrefix(node);


    }

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








