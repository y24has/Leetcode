class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost, 0), solve(cost, 1));
    }

    private int solve(int[] cost, int i) {
        // BASE CASE: If we reach the top (cost.length) or jump past it, 
        // we are done. There is no more cost to pay.
        if (i >= cost.length) {
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        // RECURSIVE CALLS & CHOICES: As you stated, we jump 1 or 2 steps
        int jumpOne = solve(cost, i + 1);
        int jumpTwo = solve(cost, i + 2);
        
        dp[i]=cost[i] + Math.min(jumpOne, jumpTwo);
        // CALCULATION: Cost of current step + minimum of our future choices
        return cost[i] + Math.min(jumpOne, jumpTwo);
    }
}