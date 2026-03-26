class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour<=(dist.length-1)) return -1;
        int lo = 1, hi = (int)1e7;
        // for (int distance: dist) {
        //     hi = Math.max(hi,distance);
        // }
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isCondition(mid,dist,hour)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (isCondition(lo,dist,hour)) return lo;
        return hi;
    }
    private static boolean isCondition(int speed, int[] dist, double hour) {
        double currtHour=0;
        double time=0;
        int i=0;
        for (int d :dist){
          if(i!=dist.length-1)  {
            time=(d+speed-1)/speed;
          }
          else{
            time=(double) d/speed;
          }
            currtHour+=time;
            i++;
        }
        return currtHour<=hour;
    }
}