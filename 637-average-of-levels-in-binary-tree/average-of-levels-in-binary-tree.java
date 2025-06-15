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
    public List<Double> averageOfLevels(TreeNode root) {
         List<Double> ans=new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);
        double sum=0.0;
       // ans.add(sum);
        while(!q.isEmpty()){
           int n=q.size();
           sum=0;
           for(int i=0;i<n;i++){
           TreeNode curr=q.poll();
           sum+=curr.val;
           if(curr.left!=null) q.offer(curr.left);
           if(curr.right!=null) q.offer(curr.right);     
        }
        ans.add(sum/n);
        }
        return ans;
    }
}