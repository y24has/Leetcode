class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b) -> b - a);
        int x=0;
        int y=0;
        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size()>1){
            y=pq.poll();
            x=pq.poll();
            if(Math.abs(y-x)!=0){
                pq.offer(y-x);
            }
        }
        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}