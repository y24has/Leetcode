class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    //     if(nums==null || k<=0) return new int[0];
    //     int[] result=new int[nums.length-k+1];
    //     TreeMap<Integer, Integer> map = new TreeMap<>();
    //     for(int i=0;i<k;i++){
    //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //     }
    //     result[0]=map.lastKey();
    //     for(int i=k;i<nums.length;i++){
    //      map.put(nums[i-k],map.get(nums[i-k])-1);
    //      map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //             if(map.get(nums[i-k])==0){
    //                 map.remove(nums[i-k]);
    //             }
    //      result[i-k+1]=map.lastKey();
    //     }
    //    return result;

    int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> deletedMap = new HashMap<>();
        
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        result[0] = maxHeap.peek();
     
        for (int i = k; i < n; i++) {
          
            int outgoingElement = nums[i - k];
            deletedMap.put(outgoingElement, deletedMap.getOrDefault(outgoingElement, 0) + 1);
            
            int incomingElement = nums[i];
            maxHeap.offer(incomingElement);
            
            while (!maxHeap.isEmpty() && deletedMap.getOrDefault(maxHeap.peek(), 0) > 0) {
                int ghost = maxHeap.poll();
                deletedMap.put(ghost, deletedMap.get(ghost) - 1);
            }
            
            result[i - k + 1] = maxHeap.peek();
        }
        
        return result;
    }
}