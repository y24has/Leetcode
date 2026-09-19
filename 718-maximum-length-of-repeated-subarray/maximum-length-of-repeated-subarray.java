class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // We use Integer object array so we can use 'null' to represent unvisited squares
        Integer[][] memo = new Integer[nums1.length][nums2.length];
        int global_max_streak = 0;
        
        // YOUR EXACT LOGIC: The Main Manager
        // "From the first index, I'll try to navigate from both from zero to end for the second."
        // We force the engine to test EVERY SINGLE (i, j) coordinate as a potential starting line!
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                
                int current_streak = helper(i, j, nums1, nums2, memo);
                
                // Keep track of the absolute biggest streak we ever find!
                global_max_streak = Math.max(global_max_streak, current_streak);
            }
        }
        
        return global_max_streak;
    }
    
    private int helper(int i, int j, int[] nums1, int[] nums2, Integer[][] memo) {
        // 1. Base Case: If either pointer falls off the edge, the streak is broken (0).
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        
        // 2. Cache Check
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        int streak = 0;
        
        // 3. The Match (Extend the streak diagonally!)
        if (nums1[i] == nums2[j]) {
            streak = 1 + helper(i + 1, j + 1, nums1, nums2, memo);
        } 
        // 4. The Mismatch
        else {
            streak = 0; 
        }
        
        // 5. Store and return
        memo[i][j] = streak;
        return streak;
    }
}