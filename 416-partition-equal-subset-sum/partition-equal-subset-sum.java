class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int num:nums){
            total+=num;
        }
        if (total % 2 != 0) {
            return false;
        }
        total=total/2;
        memo=new Boolean[nums.length][total+1];
        return solve(nums,nums.length-1,total,memo); 
    }

    private boolean solve(int[] nums,int n,int total_sum,Boolean[][] memo){
        if(total_sum==0){
            return true;
        }
        
        if(n<0)return false;

        if(memo[n][total_sum] != null){
            return memo[n][total_sum];
        }

        if(total_sum<nums[n]){
            return memo[n][total_sum] =solve(nums,n-1,total_sum,memo);
        }

        memo[n][total_sum]=solve(nums,n-1,total_sum,memo)||solve(nums,n-1,total_sum-nums[n],memo);
        return memo[n][total_sum];
    }
}