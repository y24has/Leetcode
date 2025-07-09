class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans=image;
        int initialClr=image[sr][sc];
        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, -1, 1};
        dfs(ans,sr,sc,color,initialClr,image,drow,dcol);
        return ans;
    }
    
    static void dfs(int[][] ans,int sr,int sc,int color,int initialClr,int[][] image,int[] drow,int[] dcol)
{
    ans[sr][sc]=color;
    int n=image.length;
    int m=image[0].length;
    for(int i=0;i<4;i++){
        int row=sr+drow[i];
        int col=sc+dcol[i];
        if(row>=0 && row<n && col>=0 && col<m && image[row][col]==initialClr && ans[row][col]!=color ){
              dfs(ans,row,col,color,initialClr,image,drow,dcol);
        }
    }
}
}