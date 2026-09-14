class Solution {
    
    public int maxCollectedFruits(int[][] grid) {
        int n = grid.length;
        
        // 1. Child 1: The Main Diagonal Sweeper
        // Because they only have n-1 moves, they are forced to walk straight down 
        // the diagonal. We don't need DP for them, just a loop!
        int child1_score = 0;
        for (int i = 0; i < n; i++) {
            child1_score += grid[i][i];
        }
        
        // 2. Setup the caches for Child 2 and Child 3
        // We use -1 to represent 'unvisited' squares.
        int[][] memo2 = new int[n][n];
        int[][] memo3 = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo2[i][j] = -1;
                memo3[i][j] = -1;
            }
        }
        
        // 3. Dispatch Child 2 (Upper Triangle)
        // Starts at Top-Right corner: row 0, col n-1
        int child2_score = helper2(0, n - 1, grid, memo2);
        
        // 4. Dispatch Child 3 (Lower Triangle)
        // Starts at Bottom-Left corner: row n-1, col 0
        int child3_score = helper3(n - 1, 0, grid, memo3);
        
        // The Final Master Score!
        return child1_score + child2_score + child3_score;
    }
    
    private int helper2(int row, int col, int[][] grid, int[][] memo) {
        int n = grid.length;
        
        // Bouncer 1: Victory! (The Final Room)
        // If we reach the end, return 0 because Child 1 already took the fruits!
        if (row == n - 1 && col == n - 1) {
            return 0; 
        }
        
        // Bouncer 2: Out of Bounds
        if (row >= n || col < 0 || col >= n) {
            return -200000; // Return "Infinity" negative to kill this path
        }
        
        // Bouncer 3: The Diagonal Wall (Your exact rule!)
        // Child 2 is strictly forbidden from stepping on or below the diagonal.
        if (col <= row) {
            return -200000; 
        }
        
        // Cache Check
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        
        // The Engine: 3 Choices for Child 2 (Moving Downwards)
        int down_left  = helper2(row + 1, col - 1, grid, memo);
        int down       = helper2(row + 1, col, grid, memo);
        int down_right = helper2(row + 1, col + 1, grid, memo);
        
        // The Math: Find the max of the 3 futures and add the current room's fruits
        int best_future = Math.max(down_left, Math.max(down, down_right));
        int total_score = grid[row][col] + best_future;
        
        // Save and return
        memo[row][col] = total_score;
        return total_score;
    }
    
    private int helper3(int row, int col, int[][] grid, int[][] memo) {
        int n = grid.length;
        
        // Bouncer 1: Victory! (The Final Room)
        // If we reach the end, return 0 because Child 1 already took the fruits!
        if (row == n - 1 && col == n - 1) {
            return 0; 
        }
        
        // Bouncer 2: Out of Bounds
        if (row >= n || col < 0 || col >= n) {
            return -200000; // Return "Infinity" negative to kill this path
        }
        
        // Bouncer 3: The Diagonal Wall (Your exact rule!)
        // Child 3 is strictly forbidden from stepping on or above the diagonal.
        if (row <= col) {
            return -200000; 
        }
        
        // Cache Check
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        
        // The Engine: 3 Choices for Child 3 (Moving Rightwards)
        int up_right   = helper3(row - 1, col + 1, grid, memo);
        int right      = helper3(row, col + 1, grid, memo);
        int down_right = helper3(row + 1, col + 1, grid, memo);
        
        // The Math: Find the max of the 3 futures and add the current room's fruits
        int best_future = Math.max(up_right, Math.max(right, down_right));
        int total_score = grid[row][col] + best_future;
        
        // Save and return
        memo[row][col] = total_score;
        return total_score;
    }
}