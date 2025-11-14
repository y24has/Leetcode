class Solution{
    public int findPeakElement(int[] nums){
        int lo=-1;
        int hi=nums.length-1;
        // for(int num:nums){
        //     hi=Math.max(hi,num);
        // }

        while(lo+1<hi){
            int mid=lo+(hi-lo)/2;
            if(isGreater(nums,mid)){
                hi=mid;
            }else{
                lo=mid;
            }
        }
        return hi;
    }

    private static boolean isGreater(int[] nums,int index){
        if(index==nums.length-1) {
            return true;
        }
        return nums[index]>nums[index+1];
    }
}