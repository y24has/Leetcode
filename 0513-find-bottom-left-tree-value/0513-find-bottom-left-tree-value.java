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
    public int findBottomLeftValue(TreeNode root) {
         Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> ans=new ArrayList<>();
       // ans.add(root.data);
       if (root == null) return 0;
            while(!q.isEmpty()){
            int N=q.size();
            for(int i=0;i<N;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
                if(i==0){
                    ans.add(cur.val);
                }
            }
        }
        int size=ans.size();
        int leftmost=ans.get(size-1);
        return leftmost;
    }
}