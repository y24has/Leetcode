class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int len=Integer.MAX_VALUE;
        int min_len=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        //Arrays.sort(nums);
        while(right<nums.length){
            sum+=nums[right];

            while(sum>=target){
                len=right-left+1;
                min_len=Math.min(len,min_len);
                sum-=nums[left];
                left++;
            }
            right++;
        
        }
        return min_len==Integer.MAX_VALUE?0:min_len;
    }
}