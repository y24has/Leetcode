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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path_result=new ArrayList<>();
        return  pathSumList(root,path_result,targetSum,0);
        
    }
    static List<List<Integer>> pathSumList(TreeNode root,List<Integer> path,int targetSum,int currsum ){
      List<List<Integer>> result=new ArrayList<>();
      if(root==null) return result;

      path.add(root.val);
      currsum+=root.val;

      if(root.left==null && root.right==null){
        if(targetSum==currsum){
        result.add(new ArrayList<>(path));  
        }
      }
        else{
            result.addAll(pathSumList(root.left,path,targetSum,currsum));
            result.addAll(pathSumList(root.right,path,targetSum,currsum));
        }
     path.remove(path.size()-1);
     return result;

    }
}