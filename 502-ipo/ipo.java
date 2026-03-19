class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       PriorityQueue<int[]> min_cap=new PriorityQueue<>((a,b)->a[1]-b[1]);
       PriorityQueue<int[]> max_profit=new PriorityQueue<>((a,b)->b[0]-a[0]);
       int n=profits.length;

       for(int i=0;i<n;i++){
        min_cap.offer(new int[]{profits[i],capital[i]});
       }

       int profit=0;
       int completed=0;
       while(k!=0){  
        while(!min_cap.isEmpty() && min_cap.peek()[1]<=w){
           max_profit.offer(min_cap.poll());
        }
        if(max_profit.isEmpty()) break;
        w+=max_profit.poll()[0];
        k--;
       }
        return w;
    }
}