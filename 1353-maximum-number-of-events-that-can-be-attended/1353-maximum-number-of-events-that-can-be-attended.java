class Solution {
    public int maxEvents(int[][] events) {
     
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> min_pq=new PriorityQueue<>();
        int day = 1;
        int Events = 0;
        int i=0;
       while(i<events.length || !min_pq.isEmpty()) {

            while(i<events.length && events[i][0]<=day){
               min_pq.offer(events[i][1]);
               i++;
            }

            while(!min_pq.isEmpty() && min_pq.peek()<day)
            {
              min_pq.poll();
            }

            if(!min_pq.isEmpty()) {
                Events++;
                min_pq.poll();}
            day++;
        }
        return Events;
    }
}