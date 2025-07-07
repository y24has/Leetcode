class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
    List<List<Integer>> adj=new ArrayList<>();

       for(int i=0;i<n;i++)
       {
           adj.add(new ArrayList<>());
       }
        for (int[] edge : edges) {
        int u = edge[0], v = edge[1];
        adj.get(u).add(v);
        adj.get(v).add(u); 
       }
       int completeComponents=0;
       boolean[] visited = new boolean[n+1];

    for(int i=0;i<n;i++){            
        List<Integer> nodes=new ArrayList<>();
        int[] EdgeCount=new int[1]; 
        if(!visited[i]){                
            dfs(i,adj,nodes,visited,EdgeCount);
            
            int k=nodes.size();
            int expected=k*(k-1)/2;
            if(EdgeCount[0]/2==expected) {
                completeComponents++;
            }
        }
    }
     return completeComponents;
}

  static void dfs(int node,List<List<Integer>> adj,List<Integer> nodes,boolean[] visited,int[] EdgeCount){
    visited[node]=true;
   
    nodes.add(node);
    for(int neighbor:adj.get(node)){
        EdgeCount[0]++;
        if(!visited[neighbor]){
            dfs(neighbor,adj,nodes,visited,EdgeCount);
        }
     }
   }
}