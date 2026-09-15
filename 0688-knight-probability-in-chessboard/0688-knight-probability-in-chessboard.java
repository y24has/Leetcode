class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        // We use Double (object) instead of primitive double so we can easily 
        // use 'null' to represent unvisited squares, since 0.0 is a valid probability!
        Double[][][] memo = new Double[n][n][k + 1];
        
        // Call the engine!
        return helper(n, k, row, column, memo);
    }
    
    private double helper(int n, int moves_left, int row, int col, Double[][][] memo) {
        // 1. Out-of-Bounds Bouncer (The Cliff)
        // If the knight falls off, it has a 0% chance of surviving.
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0.0;
        }
        
        // 2. Victory Bouncer (The Timer)
        // If we are still on the board and the timer hits 0, we survived!
        // We return 1.0 meaning 100% chance of survival for this specific timeline.
        if (moves_left == 0) {
            return 1.0;
        }
        
        // 3. Cache Check
        if (memo[row][col][moves_left] != null) {
            return memo[row][col][moves_left];
        }
        
        // These are the exact physical offsets for all 8 "L" shaped jumps.
        // {row_change, col_change}
        int[][] knight_moves = {
            {-2, -1}, {-2, 1},  // 2 Up, 1 Left/Right
            {2, -1}, {2, 1},    // 2 Down, 1 Left/Right
            {-1, -2}, {-1, 2},  // 1 Up, 2 Left/Right
            {1, -2}, {1, 2}     // 1 Down, 2 Left/Right
        };
        
        double total_probability = 0.0;
        
        // Instead of writing 8 separate recursive calls, we just loop over the array!
        for (int[] move : knight_moves) {
            int next_row = row + move[0];
            int next_col = col + move[1];
            
            // Accumulate the probability from each possible future
            total_probability += helper(n, moves_left - 1, next_row, next_col, memo);
        }
        
        // Because the knight chooses one of the 8 moves uniformly at random,
        // we take the total probability and divide it by 8.
        double average_probability = total_probability / 8.0;
        
        // Save and return!
        memo[row][col][moves_left] = average_probability;
        return average_probability;
    }
}