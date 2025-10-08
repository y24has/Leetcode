class Solution {
    int[] row={-1,0,1,0};
    int[] col={0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        
        for(int i=0;i<n;i++){
           if(grid[i][0]==1 && !visited[i][0]) dfs(i,0,visited,grid);
            if(grid[i][m-1]==1 && !visited[i][m-1]) dfs(i,m-1,visited,grid);    
        }

        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && !visited[0][j]) dfs(0,j,visited,grid);
            if(grid[n-1][j]==1 && !visited[n-1][j]) dfs(n-1,j,visited,grid);
        }
        
        int count=0;
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]==1 && !visited[i][j]){
                count++;
               }
           }
        }
        return count;
    }
    private  void dfs(int r,int c,boolean[][] visited,int[][] grid){
    int n=grid.length;
    int m=grid[0].length;
    visited[r][c]=true;

    for(int i=0;i<4;i++){
        int delr=r+row[i];
        int delc=c+col[i];
    if(delr>=0 && delr<n && delc>=0 && delc<m && grid[delr][delc]==1 && !visited[delr][delc]){
        dfs(delr,delc,visited,grid);
    }
    }
    }
}