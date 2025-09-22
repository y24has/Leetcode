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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        ArrayDeque<Object[]> q=new ArrayDeque<>();
        q.offer(new Object[]{root,0L});
        long maxWid=0;
        while(!q.isEmpty()){
            int size=q.size();
            long first=(long)q.peekFirst()[1];
            long last=(long)q.peekLast()[1];
            for(int i=0;i<size;i++){
                Object[] curr=q.poll();
                TreeNode node=(TreeNode)curr[0];
                long idx=(long)curr[1];

                if(node.left!=null) q.offer(new Object[]{node.left,2*idx+1});
                 if(node.right!=null) q.offer(new Object[]{node.right,2*idx+2});
            }
                maxWid=Math.max(maxWid,last-first+1);
        }
        return (int)maxWid;
    }
}