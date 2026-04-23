class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
          int n = colors.length, 
            res = 0,
            len = 1;
        for(int i=1; i<n+k-1; i++) {
            
            if(colors[i%n] == colors[(i-1)%n]) { //reset
                len = 1;
                continue;
            }
            len++;
            if( len >= k )
                res++;
        }
        return res;
    }
}