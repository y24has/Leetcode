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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
           int size=q.size();
            List<Integer> lvlorder=new ArrayList<>();
            for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
            lvlorder.add(curr.val);

            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);

        }
        ans.add(lvlorder);
        }
        return ans;
    }
}