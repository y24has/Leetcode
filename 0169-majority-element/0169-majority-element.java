class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int majority_num=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]==majority_num){
                count++;
            }else if(count==0){
                majority_num=nums[i];
            }
            else{
                count--;
            }
        }

        return majority_num;
    }
}