class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
               if (a[0] == b[0]){
               return Integer.compare(a[1], b[1]);
               }
               return Integer.compare(a[0], b[0]);
               });
        int count=0;
        int[] current_window=intervals[0];

        for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
                               
            if(current_window[1]>start){
                count++;
                current_window[1]=Math.min(current_window[1],end);
            }else{   
              current_window=intervals[i];
            }
        }
        return count;
    }
}