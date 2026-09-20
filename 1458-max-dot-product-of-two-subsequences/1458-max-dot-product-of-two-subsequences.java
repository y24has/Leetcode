class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // We use Integer object array to represent unvisited squares
        Integer[][] memo = new Integer[nums1.length][nums2.length];
        
        return helper(0, 0, nums1, nums2, memo);
    }
    
    private int helper(int i, int j, int[] nums1, int[] nums2, Integer[][] memo) {
        // 1. Base Case: If either pointer falls off, we can't make any more pairs.
        // We return a massively negative number so Math.max ignores this dead end.
        if (i == nums1.length || j == nums2.length) {
            return -10000000; 
        }
        
        // 2. Cache Check
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        // 3. Universe A: Multiply them and move both forward!
        // THE FIX (The Zero Shield): If the future returns a terrible negative number, 
        // Math.max(0, future) turns it into a 0. We just take our product and walk away!
        int future_score = helper(i + 1, j + 1, nums1, nums2, memo);
        int take_both = (nums1[i] * nums2[j]) + Math.max(0, future_score);
        
        // 4. Universe B & C: The Erasers
        int skip_i = helper(i + 1, j, nums1, nums2, memo);
        int skip_j = helper(i, j + 1, nums1, nums2, memo);
        
        // 5. Get the max and return
        int max_score = Math.max(take_both, Math.max(skip_i, skip_j));
        
        memo[i][j] = max_score;
        return max_score;
    }
}