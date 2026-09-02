class Solution {
    int[][] memo;

    public int maxSatisfaction(int[] satisfaction) {
        // Sort to ensure the largest negative numbers are evaluated first
        // and the largest positive numbers receive the highest time multipliers.
        Arrays.sort(satisfaction);
        
        int n = satisfaction.length;
        // The time variable can grow up to n (if we cook every dish).
        // Sizing the second dimension to n + 1 prevents OutOfBounds errors.
        memo = new int[n][n + 1];
        
        // Fill with -1 to safely handle optimal scores that legitimately equal 0.
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        // Start the decision tree at index 0, time 1
        return helper(0, 1, satisfaction);
    }

    private int helper(int index, int time, int[] satisfaction) {
        // Base Case: No more dishes to evaluate
        if (index == satisfaction.length) {
            return 0;
        }

        // Cache Check
        if (memo[index][time] != -1) {
            return memo[index][time];
        }

        // Door 1: Pick it. Score is calculated, time advances.
        int pick = (satisfaction[index] * time) + helper(index + 1, time + 1, satisfaction);

        // Door 2: Skip it. Score is 0, time stays exactly the same.
        int skip = helper(index + 1, time, satisfaction);

        // Record the optimal choice
        memo[index][time] = Math.max(pick, skip);
        return memo[index][time];
    }
}