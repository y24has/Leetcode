class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // Edge Case: If the starting square itself is a rock, we can't even start!
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        // Initialize cache. We fill it with -1 because '0' is a valid 
        // answer (meaning 0 paths found), so we need -1 to represent 'empty'.
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        
        return helper(0, 0, obstacleGrid, memo);
    }
    
    private int helper(int row, int col, int[][] obstacleGrid, int[][] memo) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // 1. Out-of-Bounds Bouncer
        if (row >= m || col >= n) {
            return 0; 
        }
        
        // 2. The Rock Bouncer
        if (obstacleGrid[row][col] == 1) {
            return 0; 
        }
        
        // 3. Victory Bouncer
        if (row == m - 1 && col == n - 1) {
            return 1; 
        }
        
        // 4. Cache Check
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        
        // 5. The Engine (Dive Right and Dive Down)
        int ways_down = helper(row + 1, col, obstacleGrid, memo);
        int ways_right = helper(row, col + 1, obstacleGrid, memo);
        
        // 6. The Math
        int total_ways = ways_down + ways_right;
        
        // Save and return
        memo[row][col] = total_ways;
        return total_ways;
    }
}