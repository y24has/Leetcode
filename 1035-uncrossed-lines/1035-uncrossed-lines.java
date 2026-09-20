class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // Create the 2D cache
        Integer[][] memo = new Integer[nums1.length][nums2.length];
        
        // Start the engine at index 0 for both arrays
        return helper(0, 0, nums1, nums2, memo);
    }
    
    private int helper(int i, int j, int[] nums1, int[] nums2, Integer[][] memo) {
        // YOUR EXACT WORDS: "And main the base case is if any one of the things is out of bounds, we return zero."
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        
        // Cache Check
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        int max_lines = 0;
        
        // YOUR EXACT WORDS: "Like if it matches, we can do one plus helper function calling incrementing both the pointers."
        if (nums1[i] == nums2[j]) {
            max_lines = 1 + helper(i + 1, j + 1, nums1, nums2, memo);
        } 
        // YOUR EXACT WORDS: "If not, in else condition, we are going to do two types of universes... whichever gets us the max, we store that actually"
        else {
            // Universe 1: incrementing from the nums one and keeping the same pointer in nums two
            int universe1 = helper(i + 1, j, nums1, nums2, memo);
            
            // Universe 2: keeping the same pointer of nums one and incrementing it by one of nums two
            int universe2 = helper(i, j + 1, nums1, nums2, memo);
            
            max_lines = Math.max(universe1, universe2);
        }
        
        // YOUR EXACT WORDS: "whatever we get at the end we store it in the cache and we return that."
        memo[i][j] = max_lines;
        return max_lines;
    }
}