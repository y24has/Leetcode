class Solution {
    public int numIslands(char[][] grid) {
            int count=0;
            int n=grid.length;
            int m=grid[0].length;
            boolean[][] visited=new boolean[n][m];
            
            int[] drow = {-1, 1, 0, 0}; // Up, Down
            int[] dcol = {0, 0, -1, 1}; // Left, Right
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]=='1' && !visited[i][j]){
                    count+=1;
                    dfs(grid,visited,i,j,drow,dcol);
                    }
                }
            } 
            return count;
    }

    static void dfs(char[][] grid,boolean[][] visited,int sr,int sc,int[] drow,int[] dcol){
    visited[sr][sc]=true;
     int n=grid.length;
            int m=grid[0].length;
    for(int i=0;i<4;i++){
    int nrow=sr+drow[i];
    int mcol=sc+dcol[i];

    if(nrow >= 0 && nrow < n && mcol >= 0 && mcol < m && grid[nrow][mcol]=='1' && !visited[nrow][mcol]){  
        dfs(grid,visited,nrow,mcol,drow,dcol);
      }
     }
    }
}