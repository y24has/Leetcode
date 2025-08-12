class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        
        int[][] grid=new int[n][m];
        for(int[] row:grid) {
            Arrays.fill(row,Integer.MAX_VALUE);
         }
          grid[0][0]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);

        q.offer(new int[]{0,0,0});  //diff,row,col
        
         int[] drow={-1,0,1,0};
         int[] dcol={0,1,0,-1};
        while(!q.isEmpty()){
        int[] curr=q.poll();
        
        int d=curr[0],row=curr[1],col=curr[2];
      
        for(int i=0;i<4;i++){
            int r=drow[i]+row;
            int c=dcol[i]+col;

            if(r>=0 && r<n && c>=0 && c<m){
               int diff=Math.abs(heights[row][col]-heights[r][c]);
               int neweff=Math.max(d,diff);
                if(neweff<grid[r][c]){
                grid[r][c]=neweff;
                q.offer(new int[]{neweff,r,c});
                }
            }
        }        
        }
        int ans=grid[n-1][m-1];
        return ans;
    }
}