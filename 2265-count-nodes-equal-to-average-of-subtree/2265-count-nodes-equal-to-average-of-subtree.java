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

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {

        if (root == null)
            return 0;

        int originalValue = root.val;

        int left = dfs(root.left);
        int right = dfs(root.right);

        // root.val of children now contains their subtree sums
        int leftSum = (root.left == null) ? 0 : root.left.val;
        int rightSum = (root.right == null) ? 0 : root.right.val;

        // Convert current root into subtree sum
        root.val = originalValue + leftSum + rightSum;

        int nodes = left + right + 1;

        if (root.val / nodes == originalValue)
            ans++;

        return nodes;
    }
}