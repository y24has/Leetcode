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
    public TreeNode removeLeafNodes(TreeNode curr, int target) {
        if(curr==null) return null;

        curr.left=removeLeafNodes(curr.left,target);
        curr.right=removeLeafNodes(curr.right,target);
        
        if(curr.left==null && curr.right==null && curr.val==target){
            return null;
        }
        return curr;
    }
}