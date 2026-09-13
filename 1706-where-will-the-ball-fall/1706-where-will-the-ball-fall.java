class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] answer = new int[n];
        
        // The Main Manager: Drop a ball from every single starting column
        for (int start_col = 0; start_col < n; start_col++) {
            answer[start_col] = helper(0, start_col, grid);
        }
        
        return answer;
    }
    
    private int helper(int row, int col, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Victory Base Case: The ball fell completely out of the bottom!
        if (row == m) {
            return col; // Return the column it landed in!
        }
        
        // Scenario 1: The ball lands on a '\' (1) and wants to roll Right
        if (grid[row][col] == 1) {
            // Check the Wall Trap (col + 1 == n) AND your "Alike" Trap (next is -1)
            if (col + 1 == n || grid[row][col + 1] == -1) {
                return -1; // The ball gets wedged!
            }
            
            // The door is clear! Drop down and to the right.
            return helper(row + 1, col + 1, grid);
        } 
        
        // Scenario 2: The ball lands on a '/' (-1) and wants to roll Left
        else {
            // Check the Wall Trap (col - 1 < 0) AND your "Alike" Trap (next is 1)
            if (col - 1 < 0 || grid[row][col - 1] == 1) {
                return -1; // The ball gets wedged!
            }
            
            // The door is clear! Drop down and to the left.
            return helper(row + 1, col - 1, grid);
        }
    }
}