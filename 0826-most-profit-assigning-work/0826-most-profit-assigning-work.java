class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> pq_max=new PriorityQueue<>((a,b)->b[0]-a[0]);
        int n=profit.length;
        
        for(int i=0;i<n;i++){
            int job=difficulty[i];
            int wage=profit[i];

            pq_max.offer(new int[]{wage,job});
        }
         
        Arrays.sort(worker);
        for (int i = 0; i < worker.length/ 2; i++){
            int temp = worker[i];
            worker[i] = worker[worker.length - 1 - i];
            worker[worker.length - 1 - i] = temp;
        }

        int i=0;
        int max_profit=0;
        while(i<worker.length && !pq_max.isEmpty()){
            if(pq_max.peek()[1]<=worker[i]){
                max_profit+=pq_max.peek()[0];
                i++;
            }else{
                pq_max.poll();
            }
            
        }
        return max_profit;
    }
}