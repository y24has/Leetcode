class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] edge:times){
            int source=edge[0],target=edge[1],weight=edge[2];
            adj.get(source).add(new int[]{target,weight});
        }
        int N=n+1;
       int[] dist=new int[n+1];
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[k]=0;
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int source=curr[1], weight=curr[0];
           
            for(int[] neighbor:adj.get(source)){
                int node=neighbor[0];
                int time=neighbor[1];
                if(dist[node]>weight+time){
                    dist[node]=weight+time;
                    pq.add(new int[]{dist[node],node});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
    if (dist[i] == Integer.MAX_VALUE) return -1; 
}

    int max=0;
    for(int i=1;i<=n;i++){
            if(dist[i]>max){
                max =dist[i];
            }
        }
      return max;
    }
}