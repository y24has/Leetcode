class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
       int N=edges.length;
       List<List<Integer>> adj=new ArrayList<>();
       List<Set<Integer>> ancestors = new ArrayList<>();
       int[] indegree=new int[n];
        for(int i=0;i<n;i++) {
             adj.add(new ArrayList<>());
             ancestors.add(new HashSet<>());
        }
        for(int[] edge:edges){
           int u=edge[0], v=edge[1];
           adj.get(u).add(v);
           indegree[v]++;
        }
        Queue<Integer> q=new ArrayDeque();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int source=q.poll();
            

            for(int neighbor:adj.get(source)){
                indegree[neighbor]--;
                ancestors.get(neighbor).add(source);
                ancestors.get(neighbor).addAll(ancestors.get(source));
                if(indegree[neighbor]==0){
                q.add(neighbor);
              }
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> sorted = new ArrayList<>(ancestors.get(i));
            Collections.sort(sorted);
            result.add(sorted);
        }
      return result;
    }
}