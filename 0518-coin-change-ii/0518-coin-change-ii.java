class Solution {
      Integer[][] memo;

    public int change(int amount, int[] coins) {
        // Initialize cache. Rows = number of coins, Cols = amount + 1 (to include 0)
        memo = new Integer[coins.length][amount + 1];
        
        // Start at index 0 with the full target amount
        return solve(coins, 0, amount);
    }

    private int solve(int[] coins, int index, int targetLeft) {
        // 1. BASE CASE (Win Condition)
        // You said: "if target is zero... Return one."
        if (targetLeft == 0) {
            return 1; 
        }

        // 2. BASE CASE (Lose Conditions)
        // You said: "if target drops below 0, or index goes out of bounds, return 0"
        if (targetLeft < 0 || index >= coins.length) {
            return 0;
        }

        // 3. CHECK CACHE
        if (memo[index][targetLeft] != null) {
            return memo[index][targetLeft];
        }

        // 4. THE CHOICES
        // You said: "skip that" (Move to the next coin, target stays the same)
        int skip = solve(coins, index + 1, targetLeft);
        
        // You said: "keep the same index, but we are going to decrement... the target"
        int pick = solve(coins, index, targetLeft - coins[index]);

        // 5. COMBINE AND SAVE
        // You said: "whichever how many ways we get, we are gonna return that."
        int totalWays = skip + pick;
        memo[index][targetLeft] = totalWays;
        
        return totalWays;
    }
}