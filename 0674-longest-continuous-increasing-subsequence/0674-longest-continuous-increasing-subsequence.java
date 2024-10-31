class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count =1;
        int maxcount=1;
        for(int i=0;i<nums.length-1;i++){
          if(nums[i]<nums[i+1]){
            count++;
          }else {
             maxcount=Math.max(count,maxcount);
             count=1;
          }
        }
         maxcount=Math.max(count,maxcount);
        return maxcount;
    }
}