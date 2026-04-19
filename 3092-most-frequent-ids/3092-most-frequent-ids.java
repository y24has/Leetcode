class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer,Long> map=new HashMap<>();
        
       PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[1], a[1]));

        long[] res=new long[nums.length];
        
        for(int i=0;i<res.length;i++){
            int id=nums[i];
            
            long maxFreq= map.getOrDefault(id, 0L) +freq[i];

            if(maxFreq==0){
                map.remove(id);
            }else{

                map.put(id,maxFreq);
                pq.offer(new long[]{id,maxFreq});
            }
            
            while(!pq.isEmpty()){
                
                if(!map.containsKey((int)pq.peek()[0]) || pq.peek()[1]!=map.get((int)pq.peek()[0])){
                    pq.poll();
                }else{
                  break;
                }
            }
              res[i]= pq.isEmpty() ? 0 : pq.peek()[1];

        }
        return res;
    }
}