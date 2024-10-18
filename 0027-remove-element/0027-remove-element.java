class Solution {
    public int removeElement(int[] nums, int val) {
        int not_val=0;

        for(int i=0;i<nums.length;i++){
          if(nums[i]!=val){
            nums[not_val]=nums[i];
            not_val++;
          }
        }
          return not_val;
        
    }
}