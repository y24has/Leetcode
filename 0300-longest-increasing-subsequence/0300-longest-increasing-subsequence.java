class Solution {
    // 1D Memoization cache as you correctly predicted!
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        
        // Fill cache with -1 to represent "unvisited" states
        Arrays.fill(memo, -1);

        int max_overall = 0;
        
        // The Trap Fix: We try starting the sequence at every single index
        for (int i = 0; i < n; i++) {
            max_overall = Math.max(max_overall, helper(i, nums));
        }
        
        return max_overall;
    }

    private int helper(int current_index, int[] nums) {
        // Your explicit base case! (Safety first)
        if (current_index >= nums.length) {
            return 0;
        }

        // Check the cache before doing any work
        if (memo[current_index] != -1) {
            return memo[current_index];
        }

        // Start at 1 because the number itself is a sequence of length 1
        int max_len = 1; 

        // The For-Loop Chopper: scan everything to the right
        for (int i = current_index + 1; i < nums.length; i++) {
            
            // The Bouncer: Only open the door if the number is strictly greater
            if (nums[i] > nums[current_index]) {
                
                // We take 1 step to jump to this new number, plus the best sequence ahead
                int length_of_branch = 1 + helper(i, nums); 
                
                // Update our tracker if this branch was better
                max_len = Math.max(max_len, length_of_branch);
            }
        }
        
        // Save the result to our sticky note before returning
        memo[current_index] = max_len;
        return max_len;
    }
}