class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);

        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int passengers=0;
        for(int[] trip:trips){
            int numPassenger=trip[0];
            int from=trip[1];
            int to=trip[2];

            while(!minHeap.isEmpty() && from>=minHeap.peek()[2]){
                passengers-=minHeap.peek()[0];
                minHeap.poll();
            }
            if(passengers+numPassenger>capacity)return false;
            minHeap.offer(trip);
            passengers+=+numPassenger;
        }
        return true;
    }

}