class Solution {
    private static final int MOD = 1_000_000_007;
    private long totalSum = 0;
    private long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        dfs(root);
        return (int) (maxProduct % MOD);
    }

    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;
        long leftSum = dfs(node.left);
        long rightSum = dfs(node.right);
        long subTreeSum = node.val + leftSum + rightSum;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
