class Solution {
    public int longestOnes(int[] nums, int k) {
        int right=0;
        int left=0;
        int Max_len=0;
        int zero_cnt=0;
        for(right=0;right<nums.length;right++){
            int num=nums[right];
            if(num==0) zero_cnt++;
            while(zero_cnt>k){
               if(nums[left]==0) zero_cnt--;
               left++;
            }
            Max_len=Math.max(Max_len,right-left+1);
        }
        return Max_len;
    }
}