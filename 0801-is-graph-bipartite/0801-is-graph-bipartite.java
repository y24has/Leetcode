class Solution {
    public boolean isBipartite(int[][] graph) { 
     List<List<Integer>> AdjList=new ArrayList<>();
       int n=graph.length;
       int m=graph[0].length;

    //    for(int i=0;i<n;i++)
    //    {
    //     AdjList.add(new ArrayList<>());
    //    }
    //     for (int[] edge :graph) {
    //     int u = edge[0], v = edge[1];
    //     AdjList.get(u).add(v);
    //     AdjList.get(v).add(u); 
    //    }
       int[] visited=new int[n];
       Arrays.fill(visited,-1);
       for (int i = 0; i < n; i++) {
            if (visited[i]==-1) {
                if (bfs(i, graph, visited)==false) return false;
            }
        }
          return true;
    }
       private boolean bfs(int start, int[][] graph, int[] visited) {
       Queue<Integer> q=new ArrayDeque();
       q.offer(start);
       visited[start]=0;  
       int source=start;    
        while(!q.isEmpty()){
        source=q.poll();
        
    
     
        for(int neighbor:graph[source]){
            if(visited[neighbor]==-1){
            q.offer(neighbor);
            visited[neighbor]=1-visited[source];
        }
        else if(visited[neighbor]==visited[source]){
            return false;
        }
        }
    }
    return true;
    }
}