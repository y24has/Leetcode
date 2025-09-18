class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=1;
        int Max_tym=0;
        for(int t:time){
            Max_tym=Math.max(Max_tym,t);
        }
        long high=(long)Max_tym*totalTrips;

        while(low<high){
            long mid=low+(high-low)/2;
            
            if(canFinish(time,mid,totalTrips)){
                 high=mid;
            }else{
                 low=mid+1;
            }
        }
        return low;
    }
    private boolean canFinish(int[] time,long mid,int totalTrips){
        long trips=0;
        for(int t:time){
            trips+=mid/t;
            if(trips>=totalTrips) return true;
        }
        return false;
    }
}