class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int max_window=-1;
        int count=0;

        Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) 
            ? Integer.compare(b[1], a[1]) 
            : Integer.compare(a[0], b[0]));

        for(int[] interval:intervals){
            if(interval[1]>max_window){
                count++;
                max_window=interval[1];
            }
        }
    return count;
    }
}