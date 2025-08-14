class Solution {
    public int[] applyOperations(int[] nums) {
        
        int[] result=new int[nums.length];
        int idx=0;
        for(int i=0;i<nums.length-1;i++){
       
                if(nums[i]==nums[i+1]){
                    nums[idx]=nums[i]*2;
                    idx++;
                    nums[i+1]=0;
                }else{
                    nums[idx]=nums[i];
                    idx++;
                }
        }
        int idn=0;
        for(int i=0;i<result.length;i++){
            
            if(nums[i]>0){
                result[idn++]=nums[i];
            }
        }
        return result;
    }
}