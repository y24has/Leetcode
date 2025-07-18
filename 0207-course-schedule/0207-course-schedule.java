class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
       {
        adj.add(new ArrayList<>());
       }
        for (int[] edge :prerequisites) {
        int u = edge[0], v = edge[1];
        adj.get(u).add(v);
       }
       boolean[] visited=new boolean[n];
       boolean[] path_visited=new boolean[n];
       for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if(dfs(i, visited,adj,path_visited)==false) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node,boolean[] visited,List<List<Integer>> adj,boolean[] path_visited){
    visited[node]=true;
    path_visited[node]=true;
    for(int neighbor:adj.get(node)){
        if(!visited[neighbor]){
             if(dfs(neighbor,visited,adj,path_visited)==false){
                return false;
             }
        }
        else if(path_visited[neighbor]==true){
            return false;
        }
    }
    path_visited[node]=false;
    return true;   
}
}