class Solution {
    public int uniquePaths(int m, int n) {
        // 1. The Setup (The Cache)
        // A 2D array exactly the size of the grid bounds.
        // It automatically initializes with 0s.
        int[][] memo = new int[m][n];
        
        // 2. Start the engine at the top-left corner (0, 0)
        return helper(0, 0, m, n, memo);
    }
    
    private int helper(int row, int col, int m, int n, int[][] memo) {
        // Bouncer Rule 1: Out of Bounds (The Dead End)
        // Since we only move right/down, we only check the positive bounds.
        if (row >= m || col >= n) {
            return 0; // 0 paths found down this dead end
        }
        
        // Bouncer Rule 2: Victory (The Finish Line)
        if (row == m - 1 && col == n - 1) {
            return 1; // 1 valid path found!
        }
        
        // Cache Check
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        
        // The Transitions (Dive into the two universes)
        int ways_down = helper(row + 1, col, m, n, memo);
        int ways_right = helper(row, col + 1, m, n, memo);
        
        // The Math (Accumulate from both things)
        int total_paths = ways_down + ways_right;
        
        // Save to cache and return
        memo[row][col] = total_paths;
        return total_paths;
    }
}