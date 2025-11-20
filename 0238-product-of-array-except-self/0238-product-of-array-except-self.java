class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rightprod=new int[nums.length];
        int[] leftprod=new int[nums.length];
        rightprod[0]=1;
        for(int i=1;i<nums.length;i++){
        rightprod[i]=rightprod[i-1]*nums[i-1];
        }

        for(int i=nums.length-1;i>=0;i--){
        if(i==nums.length-1){
             leftprod[i]=1;
        }
        else{
            leftprod[i]=leftprod[i+1]*nums[i+1];
        }
      }
    
        for(int i=0;i<nums.length;i++){
        nums[i]=rightprod[i]*leftprod[i];
        }
    return nums;
    }
}