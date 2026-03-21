class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // STEP 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        // STEP 2: Use a list to store merged intervals
        List<int[]> merged = new ArrayList<>();
        
        // STEP 3: Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        // STEP 4: Process each interval
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            
            // Check if overlapping
            if (currentEnd >= nextStart) {
                // MERGE: extend the end of current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // NO OVERLAP: add new interval to result
                currentInterval = intervals[i];
                merged.add(currentInterval);
            }
        }
        
        // STEP 5: Convert list to array
        return merged.toArray(new int[merged.size()][]);
    }
}