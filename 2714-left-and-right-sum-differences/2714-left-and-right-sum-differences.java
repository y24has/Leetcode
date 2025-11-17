class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int[] rightsum=new int[nums.length];
        int[] leftsum=new int[nums.length];
        rightsum[0]=0;
        for(int i=1;i<nums.length;i++){
        rightsum[i]=rightsum[i-1]+nums[i-1];
        }

        for(int i=nums.length-1;i>=0;i--){
        if(i==nums.length-1){
             leftsum[i]=0;
        }
        else{
            leftsum[i]=leftsum[i+1]+nums[i+1];
        }
      }
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
        res[i]=Math.abs(rightsum[i]-leftsum[i]);
        }
    return res;
    }
}