class Solution {
public int minPathSum(int[][] grid) {
int m = grid.length;
int n = grid[0].length;

    // 1. The Setup
    // Initialize memo cache. We fill it with -1 because 
    // 0 is technically a valid path cost in this problem!
    int[][] memo = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            memo[i][j] = -1;
        }
    }
    
    // 2. Start the engine at the top-left corner
    return helper(0, 0, grid, memo);
}

private int helper(int row, int col, int[][] grid, int[][] memo) {
    int m = grid.length;
    int n = grid[0].length;
    
    // Bouncer Rule 1: Out of Bounds (The Cliff)
    // Return a massive number so Math.min NEVER picks this path.
    if (row >= m || col >= n) {
        return 200000; // Big enough to be infinity, small enough to prevent overflow
    }
    
    // Bouncer Rule 2: Victory (The Finish Line)
    // You nailed this: just return the cost of the final square!
    if (row == m - 1 && col == n - 1) {
        return grid[row][col];
    }
    
    // Cache Check
    if (memo[row][col] != -1) {
        return memo[row][col];
    }
    
    // The Transitions (Look down and look right)
    int cost_down = helper(row + 1, col, grid, memo);
    int cost_right = helper(row, col + 1, grid, memo);
    
    // The Math (Your exact logic)
    int cheapest_future = Math.min(cost_down, cost_right);
    int total_cost = grid[row][col] + cheapest_future;
    
    // Save and return
    memo[row][col] = total_cost;
    return total_cost;
}


}