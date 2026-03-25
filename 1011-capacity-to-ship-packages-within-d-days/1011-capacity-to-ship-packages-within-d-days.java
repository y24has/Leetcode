class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo=0,hi=0;
        
        for(int weight:weights){
           lo=Math.max(lo,weight);
           hi+=weight;
        }
        int mid=0;
        while(lo+1<hi){
             mid=lo+(hi-lo)/2;
            if(isCondition(mid,weights,days)){
                hi=mid;
            }else{
                lo=mid;
            }
        }
        if(isCondition(lo,weights,days))return lo;
        return hi;
    }
    
    private static boolean isCondition(int capacity,int[] weights,int days){
        int useDays=1;
        int currentWeight=0;
        int i=0;
        while(i<weights.length){
            if(currentWeight+weights[i]>capacity){
                currentWeight=0;
                useDays++;
            }
            currentWeight+=weights[i];
            i++;
        }
        return useDays<=days;    
        }
}