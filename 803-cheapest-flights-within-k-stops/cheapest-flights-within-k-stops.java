class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge:flights){
            int from=edge[0],to=edge[1],price=edge[2];

            adj.get(from).add(new int[]{price,to});
        }
        
        Queue<int[]> pq=new LinkedList<>();

        pq.offer(new int[]{0,src});
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        int level=0;
        while(!pq.isEmpty()&& level<=k){
         int size=pq.size();
         for(int i=0;i<size;i++){
          int[] curr=pq.poll();
          int time=curr[0],source=curr[1];

          for(int[] neighbor:adj.get(source)){
               int cost=neighbor[0], node=neighbor[1];
               if(time+cost<dist[node]){
               dist[node]=cost+time;
               pq.offer(new int[]{cost+time,node});
               }
          }
         }
         level++;
        }
        
     return dist[dst] == Integer.MAX_VALUE?-1:dist[dst];
    }
}