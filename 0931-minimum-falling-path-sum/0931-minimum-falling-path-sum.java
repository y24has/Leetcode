class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        // We use a 2D cache. We fill it with a massive number (200000) 
        // to represent 'unvisited' because actual path sums can be negative or 0!
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = 200000;
            }
        }
        
        int min_sum = Integer.MAX_VALUE;
        
        // Drop a ball from every single column in the top row (Row 0)
        for (int start_col = 0; start_col < n; start_col++) {
            int current_path_sum = helper(0, start_col, matrix, memo);
            min_sum = Math.min(min_sum, current_path_sum);
        }
        
        return min_sum;
    }
    
    private int helper(int row, int col, int[][] matrix, int[][] memo) {
        int n = matrix.length;
        
        // Bouncer 1: Out-of-Bounds (The Cliff)
        // If the ball falls off the left or right edge, return "Infinity" 
        // (but small enough to prevent Java integer overflow) so Math.min NEVER picks it!
        if (col < 0 || col >= n) {
            return 100000; 
        }
        
        // Bouncer 2: Victory (The Finish Line)
        // If we reach the bottom row, just return the cost of that single square!
        if (row == n - 1) {
            return matrix[row][col];
        }
        
        // Bouncer 3: Cache Check
        if (memo[row][col] != 200000) {
            return memo[row][col];
        }
        
        int down_left = helper(row + 1, col - 1, matrix, memo);
        int straight = helper(row + 1, col, matrix, memo);
        int down_right = helper(row + 1, col + 1, matrix, memo);
        
        // Find the absolute cheapest door out of the 3
        int cheapest_future = Math.min(down_left, Math.min(straight, down_right));
        
        // Add our current square's cost to the cheapest future
        int total_cost = matrix[row][col] + cheapest_future;
        
        memo[row][col] = total_cost;
        return total_cost;
    }
}