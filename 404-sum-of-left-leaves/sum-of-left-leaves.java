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
    public int sumOfLeftLeaves(TreeNode root) {
        String s="false";
        int ans=sum(root,s);
        return ans;
    }

  static int sum(TreeNode root,String leaf){
    if (root==null) return 0;
          
        if(root.left==null && root.right==null && leaf=="true"){
            return root.val;
        }
        int left_leaf=sum(root.left,"true");
        int right_leaf=sum(root.right,"false");
        int sum=left_leaf+right_leaf;
        return sum;
  }
}