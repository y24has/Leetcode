class Solution {
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        boolean[][] visited=new boolean[n][m];
        int count=0;
       int[] drow = {-1, 0, 1, 0};
       int[] dcol = {0, 1, 0, -1};
       for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && board[i][j]=='X'){
                    dfs(i,j,visited,board,drow,dcol);
                    count+=1;
                }
            }
        }
        return count;
    }

    static void dfs(int r,int c,boolean[][] visited,char[][] board,int[] drow,int[] dcol){
        visited[r][c]=true;
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<4;i++){
            int row=r+drow[i];
            int col=c+dcol[i];
            
            if(row>=0 && row< n && col>=0 && col<m && !visited[row][col] && board[row][col]=='X'){
               dfs(row,col,visited,board,drow,dcol);
            }
        }
    }
}