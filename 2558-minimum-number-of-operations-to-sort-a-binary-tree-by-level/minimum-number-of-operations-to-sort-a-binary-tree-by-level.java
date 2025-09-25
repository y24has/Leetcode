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
    public int minimumOperations(TreeNode root) {
         int swap_count=0;

         Queue<TreeNode> q=new LinkedList<>();
      
         q.offer(root);
 //        List<Integer> list=new ArrayList<>();
         while(!q.isEmpty()){
            int n=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                list.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);                  
            }
            swap_count+=check(list);

    }
    return swap_count;
    }

    private static int check(List<Integer> list){
      int swap=0;
      List<Integer> S_list=new ArrayList<>(list);
      Collections.sort(S_list);
      Map<Integer,Integer> map=new HashMap<>();
      for(int i = 0; i < list.size(); i++){
       map.put(list.get(i),i);
      }
      for(int i=0;i<list.size();i++){
        if(list.get(i).equals(S_list.get(i))) continue;

        int curr_idx=map.get(S_list.get(i));
        map.put(list.get(i),curr_idx);
        map.put(list.get(curr_idx),i);
        Collections.swap(list,curr_idx,i);
        swap++;
      }
      return swap;
    }
}