/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int ans=-1;
        int n = mountainArr.length();
        int peak=findPeakElement(mountainArr,n);
        int left = searchInc(mountainArr, 0, peak, target);
        if (left != -1) return left;

        return searchDec(mountainArr, peak + 1,n-1, target);
    }

    public int findPeakElement( MountainArray mountainArr,int n){
        int lo=-1;
        int hi=n-1;

        while(lo+1<hi){
            int mid=lo+(hi-lo)/2;
            if(isGreater(mountainArr,mid,n)){
                hi=mid;
            }else{
                lo=mid;
            }
        }
        return hi;
    }

    private boolean isGreater( MountainArray mountainArr,int index,int length){
        if(index==length-1) {
            return true;
        }
        return mountainArr.get(index)>mountainArr.get(index+1);
    }

    private int searchInc( MountainArray mountainArr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mountainArr.get(mid)== target) return mid;
            if (mountainArr.get(mid) < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    private int searchDec( MountainArray mountainArr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if ( mountainArr.get(mid) == target) return mid;
            if ( mountainArr.get(mid)> target) lo = mid + 1;
            else hi = mid - 1;
        }
    return -1;
}
}