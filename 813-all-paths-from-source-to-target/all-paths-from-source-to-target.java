class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;

       
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        dfs(0,graph,path,result);
        return result;
        
    }
    private void dfs(int source,int[][] graph,List<Integer> path,List<List<Integer>> result){
        //visited[source]=1;
        path.add(source);
        if(source==graph.length-1){
            result.add(new ArrayList<>(path));                            
        }else{
            for(int neighbor:graph[source]){
               // if(visited[neighbor]==0){
                     dfs(neighbor,graph,path,result);
                
            }
        }
        //visited[source]=0;
        path.remove(path.size() - 1);
    }
}