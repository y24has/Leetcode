class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] res=new int[nums.length];
        
        int low=0;
        int high=nums.length-1;
        for(int i=0;i<nums.length;i++){
           
           if(nums[i]%2==0){
            res[low++]=nums[i];
           }
           else{
            res[high--]=nums[i];
           }
        }
        return res;
    }
}