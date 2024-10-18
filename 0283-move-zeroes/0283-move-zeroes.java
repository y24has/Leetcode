class Solution {
    public void moveZeroes(int[] nums) {
        int non_zero_ele=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[non_zero_ele]=nums[i];
                non_zero_ele++;
        }
        }
        for(int i=non_zero_ele;i<nums.length;i++){
            nums[i]=0;
    }
    }
}