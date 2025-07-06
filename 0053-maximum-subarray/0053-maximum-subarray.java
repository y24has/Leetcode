class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxEnding=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            maxEnding=Math.max(maxEnding + nums[i],nums[i]);
            maxSum=Math.max(maxSum,maxEnding);
        }
        return maxSum;
    }
}