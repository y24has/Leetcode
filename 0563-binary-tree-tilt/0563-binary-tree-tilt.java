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
    public int findTilt(TreeNode root) {
       int[] ttl_tilt=new int[1];
       dfs(root,ttl_tilt);
       return ttl_tilt[0];
    }

    static int dfs(TreeNode root,int[] ttl_tilt){
       if(root==null)return 0;

       int ls=dfs(root.left,ttl_tilt);
       int rs=dfs(root.right,ttl_tilt);

       int tilt=Math.abs(ls-rs);
       ttl_tilt[0]+=tilt;
       return root.val+ls+rs;
    }
}