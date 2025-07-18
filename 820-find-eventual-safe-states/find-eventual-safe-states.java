class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] visited=new int[n]; 
        int[] path_visited=new int[n];
        Arrays.fill(visited,-1);
        Arrays.fill(path_visited,-1);
        List<Integer> result=new ArrayList<>();
        Stack<Integer> Topo=new Stack<Integer>();
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
            if(dfs(i,graph,visited,path_visited,Topo)==true){

            }
            }
        }
    
    while(!Topo.isEmpty()){
        result.add(Topo.pop());
        Collections.sort(result);
    }
    return result;
    }

   static boolean dfs(int node,int[][] graph,int[] visited,int[]path_visited,Stack<Integer> Topo){
    visited[node]=1;
    path_visited[node]=1;

    for(int neighbor:graph[node]){
        if(visited[neighbor]==-1){
             if(dfs(neighbor,graph,visited,path_visited,Topo)==true){
                return true;
             }
        }
        else if(path_visited[neighbor]==1){
            return true;
        }
    }
    path_visited[node]=0;
    Topo.add(node);
    return false;
   }
}