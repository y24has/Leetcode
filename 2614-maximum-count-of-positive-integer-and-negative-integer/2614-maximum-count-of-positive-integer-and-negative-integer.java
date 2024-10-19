class Solution {
    public int maximumCount(int[] nums) {
        int countPositive=0;
        int countNegative=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
            {
                countPositive++;
            }
            else if(nums[i]<0){
                countNegative++;
            }
        }
        int Maxcount=Math.max(countPositive,countNegative);
         return Maxcount;
    }
}