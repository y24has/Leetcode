class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int[][] result=new int[n][m];

        boolean[][] visited=new boolean[n][m];

        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                   q.offer(new int[]{i,j});
                   visited[i][j]=true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
             int[] drow={-1,0,1,0};
             int[] dcol={0,1,0,-1};
            for(int i=0;i<4;i++){
           
             
            int  delr=r+drow[i];
            int delcol=c+dcol[i];
             if(delr>=0 && delr<n && delcol>=0 && delcol<m )
             {
                if(isWater[delr][delcol]==0 && !visited[delr][delcol]){
               result[delr][delcol]=result[r][c]+1;
               visited[delr][delcol]=true;
               q.offer(new int[]{delr,delcol});
             }
            }
        }
        }
        return result;
    }
}