class Solution {
    public boolean check(int[] nums) {
       int breakcount= 0;
       for(int i=1;i<nums.length;i++){
       
         if (nums[i-1]>nums[i]){
            breakcount=breakcount+1;
        }
    
       }
       if(nums[nums.length-1]>nums[0]){
        breakcount++;
       } 
       if(breakcount ==0 || breakcount<=1)
       return true;
       else 
       return false;
    }
}