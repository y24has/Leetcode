class Solution {
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        int[] indegree=new int[n];
        for(int[] edge:edges){
            int source=edge[0],target=edge[1];
            adj.get(source).add(target);
            indegree[target]++;
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){       
                count++;
            }
        }
        if(count>1) return -1;
        int[] visited=new int[n];
        int[] path_visited=new int[n];

        Arrays.fill(visited,-1);
        Arrays.fill(path_visited,-1);
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                int champ=i;
                if(dfs(i,edges,adj,visited,path_visited)==false){
                   for(int j=0;j<n;j++){ 
                    if(visited[j]!=-1){
                       return champ;
                    }
                   }
                } 
            }
        }
      return -1;
    }

    static boolean dfs(int node,int[][] edges,List<List<Integer>> adj,int[] visited,int[] path_visited){
        visited[node]=1;
        path_visited[node]=1;
        
         
        for(int neighbor:adj.get(node)){
            if(visited[neighbor]==-1){
                if(dfs(neighbor,edges,adj,visited,path_visited)==true){
                    return true;
                }
                else if(path_visited[neighbor]==1){
                    return true;
                }
            }
        }
        path_visited[node]=0;
        return false;
    }
}