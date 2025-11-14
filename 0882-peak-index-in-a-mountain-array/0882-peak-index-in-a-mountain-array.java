class Solution {
    public int peakIndexInMountainArray(int[] arr) {    
       int lo=-1;
       int hi=arr.length-1;
       

        while(lo+1<hi){
            int mid=lo+(hi-lo)/2;
            if(isGreater(arr,mid)){
                hi=mid;
            }else{
                lo=mid;
            }
        }
        return hi;
    }

    private static boolean isGreater(int[] arr,int index){
        // if(index==nums.length-1) {
        //     return true;
        // }
        return arr[index]>arr[index+1];
    }
}