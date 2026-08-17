class Solution {
    long[] dp;

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        // Initialize the DP array to the size of the questions array
        dp = new long[n];
        
        // Fill the array with -1 to indicate uncalculated states.
        // We use -1 because 0 is a possible valid score (if we skip everything).
        Arrays.fill(dp, -1);
        
        // Start the recursive game from index 0
        return solve(questions, 0);
    }

    private long solve(int[][] questions, int i) {
        // 1. Base Case: If we step out of bounds, there are no points left to collect.
        if (i >= questions.length) {
            return 0;
        }

        // 2. Memoization Check: If we have already calculated this path, return it instantly.
        if (dp[i] != -1) {
            return dp[i];
        }

        // 3. Choice A: Pick the current question. 
        // We get the points, but we must jump over the next 'brainpower' questions.
        long pick = questions[i][0] + solve(questions, i + questions[i][1] + 1);

        // 4. Choice B: Skip the current question.
        // We get 0 points, but can immediately play the very next question.
        long skip = solve(questions, i + 1);

        // 5. Save and Return: Store the maximum of both choices in our DP array
        dp[i] = Math.max(pick, skip);
        
        return dp[i];
    }
}