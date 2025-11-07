class Pair {
    int val;
    int freq;

    Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> {
                if (a.freq != b.freq)
                    return a.freq - b.freq; // smaller freq first
                return b.val - a.val;       // bigger number first
            }
        );

        for(int num:map.keySet()){
            pq.add(new Pair(num,map.get(num)));
        }

        int indx=0;
        int[] result=new int[nums.length];
        while(!pq.isEmpty()){    
        Pair p=pq.poll();
        for(int i=0;i<p.freq;i++){
            result[indx++]=p.val;
        }
      }
      return result;       
    }
}