class Solution {
    public int combinationSum4(int[] nums, int target) {
        // Our 1D Cache! It only tracks the target_left.
        Integer[] memo = new Integer[target + 1];
        
        return helper(target, nums, memo);
    }
    
    private int helper(int target_left, int[] nums, Integer[] memo) {
        
        // 1. Your Losing Bouncer: "if it was less than zero, we have to return zero."
        if (target_left < 0) {
            return 0;
        }
        
        // 2. Your Winning Bouncer: "if it is equal to zero, we have to return one."
        if (target_left == 0) {
            return 1;
        }
        
        // 3. Cache Check
        if (memo[target_left] != null) {
            return memo[target_left];
        }
        
        int total_ways = 0;
        
        // 4. Your Reset Loop: "for loop at each I will start from zero index"
        for (int i = 0; i < nums.length; i++) {
            
            // We pick the number, shrink the target, and add the resulting wins!
            total_ways += helper(target_left - nums[i], nums, memo);
        }
        
        // 5. Save and Return
        memo[target_left] = total_ways;
        return total_ways;
    }
}
