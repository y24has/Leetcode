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
    public int goodNodes(TreeNode root) {
        int[] count=new int[1];
         dfs(root,root.val,count);
        return count[0];
    }

    private static void dfs(TreeNode root,int Max_val,int[] count){
        if(root==null) return;
        
        if(root.val>=Max_val){
            Max_val=root.val;
            count[0]++;
        }
        
        dfs(root.left,Max_val,count);
        dfs(root.right,Max_val,count);
        return;
    }
}