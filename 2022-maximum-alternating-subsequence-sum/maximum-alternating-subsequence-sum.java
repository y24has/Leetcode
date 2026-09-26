class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        // Your 2D Cache! 
        // Dimension 1: The index (0 to n)
        // Dimension 2: The flag (1 for Adding, 0 for Subtracting)
        // Note: We use Long because the total sum can exceed the integer limit!
        Long[][] memo = new Long[n][2];
        
        // We throw away the main for loop and just let the engine start at 0.
        // We start with the flag as 1, because the rules say the 1st number is ADDED.
        return helper(0, 1, nums, memo);
    }
    
    // The helper takes the exact two state variables you designed
    private long helper(int index, int flag, int[] nums, Long[][] memo) {
        
        // 1. Your Base Case: If we run off the board, we get 0 points!
        if (index >= nums.length) {
            return 0;
        }
        
        // 2. Cache Check
        if (memo[index][flag] != null) {
            return memo[index][flag];
        }
        
        // 3. The SKIP Universe: 
        // We don't take the number. We move forward, and the flag STAYS THE SAME.
        long skip = helper(index + 1, flag, nums, memo);
        
        // 4. The TAKE Universe:
        long take = 0;
        if (flag == 1) {
            // We are adding! We add the number, and flip the flag to 0 for the future.
            take = nums[index] + helper(index + 1, 0, nums, memo);
        } else {
            // We are subtracting! We subtract the number, and flip the flag to 1 for the future.
            take = -nums[index] + helper(index + 1, 1, nums, memo);
        }
        
        // 5. Return the absolute best choice
        long result = Math.max(take, skip);
        memo[index][flag] = result;
        
        return result;
    }
}