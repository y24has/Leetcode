class Solution {
    int MOD = 1_000_000_007;
    
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // The Cache: 2D array
        // We can initialize to 0. Since every square has at least 1 path (itself), 
        // 0 perfectly represents "unvisited".
        int[][] memo = new int[m][n];
        
        // The Main Manager (Your exact logic!)
        // Drop a ball on every single square and add up the results.
        int global_total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                global_total = (global_total + helper(i, j, grid, memo)) % MOD;
            }
        }
        
        return global_total;
    }
    
    private int helper(int row, int col, int[][] grid, int[][] memo) {
        // 1. Cache Check
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        // 2. The Base Math (Start with 1 for the square itself)
        long total_paths = 1; 
        
        // 3. The 4 Doors (Up, Down, Left, Right)
        // Check Up
        if (row - 1 >= 0 && grid[row - 1][col] > grid[row][col]) {
            total_paths += helper(row - 1, col, grid, memo);
        }
        // Check Down
        if (row + 1 < m && grid[row + 1][col] > grid[row][col]) {
            total_paths += helper(row + 1, col, grid, memo);
        }
        // Check Left
        if (col - 1 >= 0 && grid[row][col - 1] > grid[row][col]) {
            total_paths += helper(row, col - 1, grid, memo);
        }
        // Check Right
        if (col + 1 < n && grid[row][col + 1] > grid[row][col]) {
            total_paths += helper(row, col + 1, grid, memo);
        }
        
        // 4. Modulo, Store, and Return
        // We use your exact += logic above, and apply modulo once at the end!
        total_paths %= MOD;
        
        memo[row][col] = (int) total_paths;
        return (int) total_paths;
    }
}