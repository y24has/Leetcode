class MedianFinder {
    PriorityQueue<Integer> pq_max;
    PriorityQueue<Integer> pq_min;
    public MedianFinder() {
        pq_min=new PriorityQueue<>();
        pq_max=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(pq_max.isEmpty()||num<=pq_max.peek()){
           pq_max.offer(num);
        }else{
            pq_min.offer(num);
        }

        if(pq_max.size() - pq_min.size() > 1){
           pq_min.offer(pq_max.poll());
        }else if(pq_min.size() - pq_max.size() > 1){
           pq_max.offer(pq_min.poll());
        }
    }
    
    public double findMedian() {
         if(pq_max.size()==pq_min.size()){
            double avg=(pq_max.peek()+pq_min.peek())/2.0;
            return avg;
         }else if(pq_max.size()>pq_min.size()){
            return (double)pq_max.peek();
         }else{
            return (double)pq_min.peek();
         }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */