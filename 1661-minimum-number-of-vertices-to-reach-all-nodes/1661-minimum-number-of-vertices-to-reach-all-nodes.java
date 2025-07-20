class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         boolean[] indegree=new boolean[n];
         List<Integer> result=new ArrayList<>();
        for(List<Integer> edge:edges){        
           indegree[edge.get(1)]=true;
        }
        for(int j=0;j<n;j++){
         if(indegree[j]==false){
           result.add(j);
          }
        }
        return result;
    }
}