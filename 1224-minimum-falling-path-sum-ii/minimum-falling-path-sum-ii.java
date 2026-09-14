class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        
        // Edge Case: If the grid is only 1x1, we just return that single number.
        if (n == 1) {
            return grid[0][0];
        }
        
        // We use Integer.MAX_VALUE to represent 'unvisited' instead of -1 
        // because the grid can contain negative numbers!
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // The Main Manager: Drop a ball from every single column in the first row.
        int global_min = Integer.MAX_VALUE;
        for (int start_col = 0; start_col < n; start_col++) {
            int current_path_cost = helper(0, start_col, grid, memo);
            global_min = Math.min(global_min, current_path_cost);
        }
        
        return global_min;
    }
    
    private int helper(int row, int col, int[][] grid, int[][] memo) {
        int n = grid.length;
        
        // 1. Victory Bouncer: If we reach the very last row, 
        // there are no more jumps to make. Just return this square's cost!
        if (row == n - 1) {
            return grid[row][col];
        }
        
        // 2. Cache Check
        if (memo[row][col] != Integer.MAX_VALUE) {
            return memo[row][col];
        }
        
        // 3. The Engine: Prepare to find the absolute cheapest future path.
        int min_future_cost = Integer.MAX_VALUE;
        
        // Look at EVERY column in the row below us (row + 1)
        for (int next_col = 0; next_col < n; next_col++) {
            
            // Your exact rule: If it's the same column, skip it!
            if (next_col == col) {
                continue;
            }
            
            // It's a valid door, so dive in!
            int future_cost = helper(row + 1, next_col, grid, memo);
            
            // Keep track of the minimum cost we've found so far
            min_future_cost = Math.min(min_future_cost, future_cost);
        }
        
        // 4. The Math: Add our current square's cost to the best future path
        int total_cost = grid[row][col] + min_future_cost;
        
        // 5. Store and Return!
        memo[row][col] = total_cost;
        return total_cost;
    }
}