class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
       for(int i=0;i<n;i++){
        dfs(0,rooms,visited);
          
        for(boolean v:visited){
            if(!v) return false;
        }
       }
        return true;
    }

    static void dfs(int node ,List<List<Integer>> rooms,boolean[] visited){
        visited[node]=true;
        for (int key : rooms.get(node)) {
        if(!visited[key]){
            dfs(key,rooms,visited);
        }
    }
}}