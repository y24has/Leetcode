class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        
        // The 2D Cache: [index][state]
        // state 1 = needUp is true
        // state 0 = needUp is false
        int[][] memo = new int[nums.length][2];
        int global_max = 1;
        
        // The Main Manager: Ask every index for its best path
        for (int i = 0; i < nums.length; i++) {
            
            // We don't know if the sequence should start by going UP or DOWN.
            // So, we just try both!
            int startGoingUp = helper(nums, i, true, memo);
            int startGoingDown = helper(nums, i, false, memo);
            
            global_max = Math.max(global_max, Math.max(startGoingUp, startGoingDown));
        }
        
        return global_max;
    }
    
    // The 2D Top-Down DP Engine
    private int helper(int[] nums, int i, boolean needUp, int[][] memo) {
        // 1. Convert boolean to an integer index for the cache (1 for true, 0 for false)
        int state = needUp ? 1 : 0;
        
        // 2. Cache Check
        if (memo[i][state] != 0) {
            return memo[i][state];
        }
        
        // 3. Local max starts at 1 (the number itself is a valid sequence of length 1)
        int max_len = 1;
        
        // 4. The Bouncer Loop (Look forward)
        for (int j = i + 1; j < nums.length; j++) {
            
            // Rule 1: We need to go UP, and the future number is bigger
            if (needUp && nums[j] > nums[i]) {
                int length_of_branch = 1 + helper(nums, j, !needUp, memo);
                max_len = Math.max(max_len, length_of_branch);
            } 
            // Rule 2: We need to go DOWN, and the future number is smaller
            else if (!needUp && nums[j] < nums[i]) {
                int length_of_branch = 1 + helper(nums, j, !needUp, memo);
                max_len = Math.max(max_len, length_of_branch);
            }
        }
        
        // 5. Save and Return
        memo[i][state] = max_len;
        return max_len;
    }
}