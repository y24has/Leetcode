class Pair{
    int row;
    int col;
    int tm;

    Pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
} 

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int count_One=0;
        Queue<Pair> q=new LinkedList<>();
     
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]== 2 ){
                       q.offer(new Pair(i,j,0));
                       visited[i][j]=true; 
                }else if(grid[i][j]==1){
                      count_One+=1;
                }
            }
        }
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        int cnt=0;
        int tym=0;
        while(!q.isEmpty()){
           // Pair orrage=q.peek();
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tym=Math.max(t,tym);
            q.remove();
           
            for(int i=0;i<4;i++){
            int nr=r+drow[i];
            int nc=c+dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1 && !visited[nr][nc]){
                       q.offer(new Pair(nr,nc,t+1));
                        visited[nr][nc]=true; 
                        cnt++;
                }
            }
        }
       if(count_One!=cnt) return -1;
       return tym;
    }
}