class Solution {
    public int maxDistance(int[] position, int m) {
            Arrays.sort(position);  // Step 1: sort

        int lo =-1;
        int hi = position[position.length - 1] - position[0];

        int ans = 0;

        while (lo+1<hi) {
            int mid = lo + (hi - lo) / 2;

            if (canPlace(position, m, mid)) {
                ans = mid;          // mid is valid
                lo = mid;       // try bigger distance
            } else {
                hi=mid;       // reduce distance
            }
        }
        if (canPlace(position, m, hi)) return hi;
        return ans;
    }

    private boolean canPlace(int[] pos, int m, int dist) {
     int count=1;
     int last=pos[0];
     int i=1;
     while(i<pos.length){
        if(pos[i]-last>=dist){
            count++;
            last=pos[i];
            
            if(count>=m) return true;
        }
        i++;
     }
     return false;
    }
}