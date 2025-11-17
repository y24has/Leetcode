class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        
        int j=nums.length;
        int count=0;
        int lastpos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                lastpos=i;
                break;
            }
        }
        int start=lastpos+1;
        while(start<j){
          if(nums[start]==1){
           int gap=start-lastpos-1;
            if(!(gap>=k)){
               return false;
            }
            lastpos=start;
          }
            start++;
          }
        return true;
    }
}