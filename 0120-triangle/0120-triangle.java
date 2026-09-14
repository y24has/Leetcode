class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // We use an Integer object array instead of int[][] 
        // so we can use 'null' to represent unvisited squares.
        // This avoids the trap of using -1, since the triangle can have negative numbers!
        Integer[][] memo = new Integer[n][n];
        
        // We start right at the top tip of the triangle!
        return helper(0, 0, triangle, memo);
    }
    
    private int helper(int row, int col, List<List<Integer>> triangle, Integer[][] memo) {
        // 1. Victory Bouncer: We reached the very last row!
        // Return the cost of this square directly without falling off the edge.
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }
        
        // 2. Cache Check
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        
        // 3. The Engine: Gravity only gives us two doors!
        // Door 1: Straight down (same index)
        int down = helper(row + 1, col, triangle, memo);
        
        // Door 2: Diagonally down-right (index + 1)
        int down_right = helper(row + 1, col + 1, triangle, memo);
        
        // 4. The Math: Current room's cost + cheapest future path
        int current_cost = triangle.get(row).get(col);
        int min_total = current_cost + Math.min(down, down_right);
        
        // 5. Store and return
        memo[row][col] = min_total;
        return min_total;
    }
}