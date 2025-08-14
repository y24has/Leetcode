class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j=nums.length-1;

        int[] result=new int[nums.length];
        int p=result.length-1;
        while(i<=j){
        int start_sq=nums[i]*nums[i];
        int end_sq=nums[j]*nums[j];

        if(start_sq>end_sq){
          result[p]=start_sq;
          p--;
          i++;
        }else{
           result[p]=end_sq;
           p--;
           j--;
        }
        }
        return result;
    }
}