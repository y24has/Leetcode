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
    long secondMin = Long.MAX_VALUE;
    int minVal;

    public int findSecondMinimumValue(TreeNode root) {

        minVal = root.val;

        dfs(root);

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    private void dfs(TreeNode node) {

        if (node == null) return;

        if (node.val > minVal) {
            secondMin = Math.min(secondMin, node.val);
        }

        dfs(node.left);
        dfs(node.right);
    }}