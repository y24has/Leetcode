class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefixSum=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
        prefixSum[i+1]=prefixSum[i]+nums[i];
        }
        int leftSum=0;
        int rightSum=0;
        int[] AbslteDiff=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            leftSum=nums[i] * i- prefixSum[i];
            rightSum=(prefixSum[nums.length]-prefixSum[i+1])-nums[i]*(nums.length-i-1);
            AbslteDiff[i]=leftSum+rightSum;
        }
        return AbslteDiff;
    }
}