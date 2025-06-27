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
    public int maxDepth(TreeNode root) {
       int max_depth=0;
       max_depth=m_Depth(root);
       return max_depth;
       }

       static int m_Depth(TreeNode root){
        if(root==null) return 0;

        int ls=m_Depth(root.left);
        int rs=m_Depth(root.right);
    
        return 1+Math.max(ls,rs);
       }
    }