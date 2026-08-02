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
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int maxFreq = 0;
        List<Integer> ans = new ArrayList<>();

        for (int sum : map.keySet()) {
            int freq = map.get(sum);
            if (freq > maxFreq) {
                maxFreq = freq;
                ans.clear();
                ans.add(sum);
            }
            else if (freq == maxFreq) {
                ans.add(sum);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        int subtreeSum = leftSum + rightSum + root.val;

        map.put(subtreeSum, map.getOrDefault(subtreeSum, 0) + 1);
        return subtreeSum;
    }
}