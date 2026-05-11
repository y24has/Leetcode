class Solution {
    public int findCenter(int[][] edges) {
        
        int[] degree=new int[edges.length+2];
   
        for(int[] edge:edges){
            int source=edge[0],target=edge[1];
            degree[source]++;
            degree[target]++;
        } 
        for(int i=1;i<=degree.length;i++){
            if(degree[i]==degree.length-2){
                return i;
            }
        }
        return -1;
    }

}