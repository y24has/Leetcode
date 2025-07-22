class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] peri=new int[n*m];
        boolean[][] visited=new boolean[n][m];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){ 
                dfs(i,j,visited,grid,peri,drow,dcol);
            }
        }
        }
        int perimeter=peri[0];
        return perimeter;
    }

    static void dfs(int r,int c,boolean[][] visited,int[][] grid,int[] peri,int[] drow,int[] dcol){
        int n=grid.length;
        int m=grid[0].length;
          visited[r][c] = true;
    
       for(int i=0;i<4;i++){
           int row=r+drow[i];
           int col=c+dcol[i];
           if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0){
            peri[0]++;
           }
           else if(!visited[row][col]){
            dfs(row, col, visited, grid, peri, drow, dcol);
           }
                
       }
    
    }
}