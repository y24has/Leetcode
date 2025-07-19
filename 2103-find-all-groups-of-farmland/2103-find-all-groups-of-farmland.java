class Solution {
    public int[][] findFarmland(int[][] land) {
        int n=land.length;
        int m=land[0].length;

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
       // int[][] result=new int[4][4];
        boolean[][] visited=new boolean[n][m];

        List<int[]> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int[] row={-1};
                int[] col={-1};
                if(!visited[i][j] && land[i][j]==1){
                dfs(i,j,land,drow,dcol,row,col,visited);
                  result.add(new int[]{i,j,row[0],col[0]});
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

   static void dfs(int r,int c,int[][] land,int[] drow,int[] dcol,int[] row,int[] col,boolean[][] visited){
       int n=land.length;
        int m=land[0].length;
      visited[r][c]=true;
      row[0]=Math.max(row[0],r);
      col[0]=Math.max(col[0],c);

      for(int i=0;i<4;i++){
        int Del_row=r+drow[i];
        int Del_col=c+dcol[i];

        if(Del_row>=0 && Del_row<n && Del_col>=0 && Del_col<m && !visited[Del_row][Del_col] && land[Del_row][Del_col]==1){
             dfs(Del_row,Del_col,land,drow,dcol,row,col,visited);
        }
      }
   }
}