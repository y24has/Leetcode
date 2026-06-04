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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        TreeNode curr = dummy;
        curr = inorder(root, curr);
        return dummy.right;
    }

    private TreeNode inorder(TreeNode node, TreeNode curr) {
        if (node == null) return curr;
        curr = inorder(node.left, curr);
        node.left = null;
        curr.right = node;
        curr = node;
        return inorder(node.right, curr);
    }
}