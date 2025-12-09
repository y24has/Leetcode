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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        helperFun(list,root);
        return list;
    }

     void helperFun(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }

       // List<Integer> list=new ArrayList<>();
        list.add(root.val); 
     helperFun(list,root.left);
          helperFun(list,root.right);
        }
    
}