class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // We fill the cache with -1 because 0 is a valid number of moves
        // (e.g., if we start on a square and all 3 doors are immediately blocked).
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        
        int max_moves = 0;
        
        // The rules say we can start at ANY row in the very first column (col 0).
        // So the Main Manager tries starting at every single one and keeps the global best!
        for (int i = 0; i < m; i++) {
            max_moves = Math.max(max_moves, helper(i, 0, grid, memo));
        }
        
        return max_moves;
    }
    
    private int helper(int row, int col, int[][] grid, int[][] memo) {
        // 1. Cache Check
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        // Default to 0 moves if the doors don't open
        int up_right = 0, straight = 0, down_right = 0;
        
        // 2. Check the Up-Right Door
        // Bouncer rules: Row must not fall off the top edge, Col must not fall off the right edge,
        // AND the next number must be strictly greater than the current number.
        if (row - 1 >= 0 && col + 1 < n && grid[row - 1][col + 1] > grid[row][col]) {
            up_right = 1 + helper(row - 1, col + 1, grid, memo);
        }
        
        // 3. Check the Straight Right Door
        if (col + 1 < n && grid[row][col + 1] > grid[row][col]) {
            straight = 1 + helper(row, col + 1, grid, memo);
        }
        
        // 4. Check the Down-Right Door
        if (row + 1 < m && col + 1 < n && grid[row + 1][col + 1] > grid[row][col]) {
            down_right = 1 + helper(row + 1, col + 1, grid, memo);
        }
        
        // 5. The Math: Bubble up the absolute biggest chain we found
        int current_max = Math.max(up_right, Math.max(straight, down_right));
        
        // 6. Save and Return
        memo[row][col] = current_max;
        return current_max;
    }
}