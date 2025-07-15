class Pair{
    int row;
    int col;
    int steps;

    Pair(int row,int col,int steps){
     this.row=row;
     this.col=col;
     this.steps=steps;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;
        boolean[][] visited=new boolean[n][m];
        visited[entrance[0]][entrance[1]]=true;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //        if(maze[i][j]=='.' && !visited[i][j]){
        //             visited[i][j]=true;
        //         }
        //     }
        // }
        int[] drow = {-1, +1, 0, 0}; 
        int[] dcol = {0, 0, -1, +1}; 


        Queue<Pair> q=new ArrayDeque<>(); 
        q.offer(new Pair(entrance[0],entrance[1],0));
        int exit=-1;
        while(!q.isEmpty()){
        Pair entry=q.poll();
        int row=entry.row;
        int col=entry.col;
        int step=entry.steps;
   
        
        if(( row==0 || row==n-1 || col==0 || col==m-1) && !(row==entrance[0] && col==entrance[1]) ){
       
            return step;
        }
        for(int i=0;i<4;i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                maze[nrow][ncol]== '.' && !visited[nrow][ncol]) {
                   
                  visited[nrow][ncol] = true;
                  q.offer(new Pair(nrow,ncol,step+1));
            }
          }
        }

        return -1;
    }
}