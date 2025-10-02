class Solution {
    private int count;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited=new boolean[n];
        List<List<Integer>> adjlist=new ArrayList<>();
        for(int i=0;i<n;i++) adjlist.add(new ArrayList<>());
        for(int[] edge:edges){
        adjlist.get(edge[0]).add(edge[1]);
        adjlist.get(edge[1]).add(edge[0]);
        }
        count=0;
        dfs(source,adjlist,visited);
        if(count==n)return true;

        return visited[destination];
    }
    public void dfs(int source,List<List<Integer>> adjlist,boolean[] visited){
        count++;
        visited[source]=true;   
        for(int node:adjlist.get(source)){
            if(!visited[node]){
                dfs(node,adjlist,visited);
            }
        }
    }
}