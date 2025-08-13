class Solution {
    public int minTimeToReach(int[][] moveTime) {
       int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // PriorityQueue to hold entries as (time, i, j)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int wait=0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int i = curr[1];
            int j = curr[2];
          
            if (i == m - 1 && j == n - 1) {
                return currTime;
            }
            
            for (int o=0;o<4;o++) {
                int i_ = i + drow[o];
                int j_ = j + dcol[o];
                 if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n) {
                  int arrTime=currTime;
                   if(currTime<moveTime[i_][j_]){
                     wait = moveTime[i_][j_] - currTime;
                     arrTime+=wait;
                   }
                    arrTime++;
                    if (result[i_][j_] > arrTime) {
                        result[i_][j_] = arrTime;
                        pq.offer(new int[]{arrTime, i_, j_});
                    }
                }
            }
        }
    return -1; 
    }
}