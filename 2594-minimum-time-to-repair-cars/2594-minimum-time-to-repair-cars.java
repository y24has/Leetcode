class Solution {
    public long repairCars(int[] ranks, int cars) {
        long lo=0;
        long hi=Long.MAX_VALUE;
     
        for (int r : ranks) {
        hi= Math.min(hi, r);
        }
         hi = (long) hi * cars * cars;
        while(lo+1<hi){
            long mid=lo+(hi-lo)/2;

            if(isRepair(mid,ranks,cars)){
                hi=mid;
            }else{
                lo=mid;
            }
        }
       return hi;
    }

    public static boolean isRepair(long work,int[] ranks,int cars){
        long totalCars=0;

        for(int rank:ranks){
            totalCars+=(long)Math.sqrt(work/(double)rank);
        
        if(totalCars>=cars) return true;
    }
    return totalCars>=cars;
   }
}