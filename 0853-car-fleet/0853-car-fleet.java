class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> pq=new PriorityQueue<>( (a,b)->b[0]-a[0]);
        int n=position.length;
        for(int i=0;i<n;i++){
            pq.offer(new int[]{position[i],speed[i]});
        }
        Stack<Double> s=new Stack<>();
        for(int i=0;i<n;i++){
            int[] car=pq.poll();
            double time=(double)(target-car[0])/car[1];
            
            if(s.isEmpty() || time>s.peek()){
                s.push(time);
            }

        }
        return s.size();
    }
}