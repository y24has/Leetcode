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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum=0;
        return pathSum(root,sum,targetSum);
            }

    static boolean pathSum(TreeNode root,int currsum, int targetSum){
        if(root!=null)currsum+=root.val;
        if(root==null) return false;
        
        if(root.left==null &&root.right==null){
            return targetSum==currsum;
                 }
        // boolean left=pathSum(root.left,currsum,targetSum);
        // boolean right=pathSum(root.right,currsum,targetSum);
        return pathSum(root.left,currsum,targetSum)||pathSum(root.right,currsum,targetSum);
    }
}