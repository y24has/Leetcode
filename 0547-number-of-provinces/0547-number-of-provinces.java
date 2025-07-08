class Solution {
    public int findCircleNum(int[][] isConnected) {
       List<List<Integer>> adj=new ArrayList<>();
       int n=isConnected.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
       for (int i = 0; i < n; i++) {
       for (int j = 0; j < n; j++) {
        if (i != j && isConnected[i][j] == 1) {
            adj.get(i).add(j);
        }
    }
}
       int count=0;
       boolean[] visited=new boolean[n];
       for(int i=0;i<n;i++){
        if(!visited[i]){
            dfs(i,adj,visited);
            count++;
        }
       }
       return count;
    }
    static void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;

        for(int neighbor:adj.get(node)){
            if(!visited[neighbor] ){
            dfs(neighbor,adj,visited);
        }
        }
    }
}