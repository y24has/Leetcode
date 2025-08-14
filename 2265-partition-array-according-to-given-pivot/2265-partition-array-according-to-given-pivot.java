class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int low=0;
        int[] result=new int[nums.length];
 
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
              result[low]=nums[i];
              low++;
            }
            }
            for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot){
                result[low]=nums[i];
                low++;
                }
            }
            for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot){
                result[low]=nums[i];
                low++;
            }
        }
        return result;
    }
}