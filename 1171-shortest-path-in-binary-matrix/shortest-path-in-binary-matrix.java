class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, - 1};
        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{0,0,0});
        boolean[][] visited=new boolean[n][m];
        visited[0][0]=true;
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int dist=curr[0];
            int row=curr[1],col=curr[2];
            
            if(row==n-1 && col==m-1) return dist+1; 

            for(int i=0;i<8;i++){
                int r=row+dx[i];
                int c=col+dy[i];

                if(r>=0 && r<n && c>=0 && c<m && !visited[r][c] && grid[r][c]==0){
                    visited[r][c]=true;
                    q.offer(new int[]{dist+1,r,c});
                }
            }

        }
        return -1;
    }
}