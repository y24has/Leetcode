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
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int[] Diameter=new int[1];
        Diameter[0]=Integer.MIN_VALUE;
        diameter(root,Diameter);
        return Diameter[0];
    }

    static int diameter(TreeNode root,int[] Diameter){
      if(root==null) return 0;
      int ls=Math.max(0,diameter(root.left,Diameter));
      int rs=Math.max(0,diameter(root.right,Diameter));
      Diameter[0]=Math.max(Diameter[0],root.val+ls+rs);
      return root.val+Math.max(ls,rs);
    }
}