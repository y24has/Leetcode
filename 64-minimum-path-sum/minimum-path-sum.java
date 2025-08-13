class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] min=new int[n][m];

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);

        q.offer(new int[]{grid[0][0],0,0});
        for(int[] row:min){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        min[0][0]=grid[0][0];
        int[] drow = {1, 0};  // down, right
        int[] dcol = {0, 1};  // down, right


        while(!q.isEmpty()){
            int[] curr=q.poll();
            int val=curr[0],row=curr[1],col=curr[2];
            
            for(int i=0;i<2;i++){
                int r=row+drow[i];
                int c=col+dcol[i];

                if(r >= 0 && r < n && c >= 0 && c < m){
               int newsum=val+grid[r][c];
               if(newsum<min[r][c]){
                min[r][c]=newsum;
                q.offer(new int[]{newsum,r,c});
               }

                }
            }

        }
     return min[n-1][m-1];
    }

}