class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] visited=new int[n]; 
        int[] path_visited=new int[n];
        Arrays.fill(visited,-1);
        Arrays.fill(path_visited,-1);
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
            dfs(i,graph,visited,path_visited);
            }
        }
    List<Integer> result=new ArrayList<>();
    for(int i=0;i<n;i++){
    if(path_visited[i]==0){
        result.add(i);
    }
    }
    return result;
    }

   static boolean dfs(int node,int[][] graph,int[] visited,int[]path_visited){
    visited[node]=1;
    path_visited[node]=1;

    for(int neighbor:graph[node]){
        if(visited[neighbor]==-1){
             if(dfs(neighbor,graph,visited,path_visited)==true){
                return true;
             }
        }
        else if(path_visited[neighbor]==1){
            return true;
        }
    }
    path_visited[node]=0;
    return false;
   }
}