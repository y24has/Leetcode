/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long max_prod = 0;
    long sum = 0;
    public int maxProduct(TreeNode root) {
        // First helper: calculate total sum
        sum = getSum(root);
        // Second helper: try every possible split
        solve(root);
        return (int)(max_prod % 1_000_000_007);
    }

    private long getSum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val
                + getSum(root.left)
                + getSum(root.right);
    }

    private long solve(TreeNode root) {
        if (root == null)
            return 0;
        long left = solve(root.left);
        long right = solve(root.right);
        long subtreeSum = left + right + root.val;
        long diff = sum - subtreeSum;
        max_prod = Math.max(max_prod, subtreeSum * diff);
        return subtreeSum;
    }
}