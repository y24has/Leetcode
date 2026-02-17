class Solution {
    public int minDifference(int[] nums) {
        int minDiff=0;
        Arrays.sort(nums);
        int n=nums.length;
        if(n<=3) return 0;
        int case1=nums[n-4]-nums[0];
        int case2=nums[n-3]-nums[1];
        int case3=nums[n-2]-nums[2];
        int case4=nums[n-1]-nums[3];

        minDiff=Math.min(Math.min(case1,case2),Math.min(case3,case4));
        return minDiff;
    }
}