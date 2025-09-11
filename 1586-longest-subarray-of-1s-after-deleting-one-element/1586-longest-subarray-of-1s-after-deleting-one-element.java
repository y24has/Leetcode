class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;int right=0;
        int len=0;
        int zero_cnt=0;

        for(right=0;right<nums.length;right++){
            int zero=nums[right];

         if(zero==0){
               zero_cnt+=1;
            }
            while(zero_cnt>1){
              if(nums[left]==0)  zero_cnt--;
                 left++;
            }
            len=Math.max(right-left+1,len);
        }
        return len-1;
    }
}