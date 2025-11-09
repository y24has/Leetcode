class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans = new int[nums.length- k + 1];

        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
       
        ans[0]=compute(map,x);
        int idx=1;
        for(int i=k;i<nums.length;i++){
            int toremove=nums[i-k];
            map.put(toremove,map.getOrDefault(toremove,0)-1);
            if(map.get(toremove)==0) map.remove(toremove);

            int toadd=nums[i];
            map.put(toadd,map.getOrDefault(toadd,0)+1);
            
            ans[idx++]=compute(map,x);
        }
        return ans;
    }


private static int compute(Map<Integer,Integer> map,int x){
    PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> {
                if (!a.getValue().equals(b.getValue()))
                    return b.getValue() - a.getValue();   // frequency DESC
                return b.getKey() - a.getKey();           // value DESC
        });
    
    pq.addAll(map.entrySet());
          
   PriorityQueue<Map.Entry<Integer, Integer>> copy =
            new PriorityQueue<>(pq);

    int sum=0;
    int taken=0;

    while(taken<x && !copy.isEmpty()){
         Map.Entry<Integer, Integer> e = copy.poll();
            sum += e.getKey() * e.getValue();
            taken++;
    }
    return sum;
    }
}