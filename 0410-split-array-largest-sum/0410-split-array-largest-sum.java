class Solution {
    public int splitArray(int[] nums, int k) {
        int lo=0;
        int hi=0;
        for(int num:nums){
            lo=Math.max(lo,num);
            hi+=num;
        }

        while(lo+1<hi){
            int mid=lo+(hi-lo)/2;
            if(canSplit(mid,nums,k)){
                hi=mid;
            }else{
                lo=mid;
            }
        }
          if(canSplit(lo,nums,k)) return lo;
        return hi;
    }

    private static boolean canSplit(int mid,int[] nums,int k){
        int parts=1;
        int maxSum=0;
        for(int num:nums){
        if(maxSum+num>mid){
            maxSum=0;
            parts++;
        }
        maxSum+=num;
        }
        return parts<=k;
    }
}