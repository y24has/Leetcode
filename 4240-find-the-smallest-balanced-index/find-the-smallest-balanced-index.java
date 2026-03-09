class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long[] prefix_sum=new long[nums.length];


        prefix_sum[0]=nums[0];
        for(int j=1;j<nums.length;j++)
        {
             prefix_sum[j]=prefix_sum[j-1]+nums[j];
        }
        long product=1l;
          int index=-1;
        for(int i=nums.length-1;i>0;i--){
            if(prefix_sum[i-1]==product){
                index=i;
            }
            // prevent overflow / unnecessary huge values
            if(product >prefix_sum[i]) {
             return index; 
            }
            product = product * nums[i];
      }
    return index;
    }
}