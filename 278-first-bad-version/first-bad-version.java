/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long lo=-1;
        long hi=n;

        while(lo+1<hi){
            long mid=lo+(hi-lo)/2;
            if(isBadVersion((int)mid)){
                hi=mid;
            }
            else{
                lo=mid;
            }
        }
        return (int)hi;
    }
}