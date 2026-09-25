class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        
        int total_slices = 0;
        
        // Our cache to remember the streak moving forward from a specific index
        Integer[] memo = new Integer[n];
        
        // Your Main Loop: We walk through the array to grab our baseline difference!
        // We stop at n - 2 because we need at least i, i+1, and i+2 to make a slice.
        for (int i = 0; i < n - 2; i++) {
            
            // We lock in the exact difference between 'i' and 'i+1'
            int baseline_diff = nums[i + 1] - nums[i];
            
            // We pass the index we want to test (i + 2) AND the difference into the helper!
            total_slices += helper(i + 2, nums, baseline_diff, memo);
        }
        
        return total_slices;
    }
    
    // Your Helper Function with the 'difference' passed in!
    private int helper(int index, int[] nums, int diff, Integer[] memo) {
        
        // Base Case 1: We walked off the edge of the array
        if (index >= nums.length) {
            return 0;
        }
        
        // Your Strict Bouncer! 
        // If the current difference does NOT match the baseline difference, 
        // the contiguous slice is broken. "or else we can just return like this" -> return 0!
        if (nums[index] - nums[index - 1] != diff) {
            return 0;
        }
        
        // Cache Check
        if (memo[index] != null) {
            return memo[index];
        }
        
        // The difference matched! We get 1 slice for ourselves...
        // ...and we ask the future to keep checking the exact same difference!
        int current_streak = 1 + helper(index + 1, nums, diff, memo);
        
        // Save and return
        memo[index] = current_streak;
        return current_streak;
    }
}