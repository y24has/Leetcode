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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        if(root==null)return false;
        if(isSame(root,subRoot)) return true;
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
    static boolean isSame(TreeNode root,TreeNode sbRoot){
        if(root==null && sbRoot==null)return true;
         if(root==null||sbRoot==null) return false;
        if(root.val!=sbRoot.val) return false;
        return isSame(root.left,sbRoot.left)&&isSame(root.right,sbRoot.right);
    }
}