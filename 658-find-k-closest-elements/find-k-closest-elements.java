class Pair {
    int diff;
    int val;

    Pair(int value, int priority) {
        this.diff = value;
        this.val = priority;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.diff == b.diff) return a.val - b.val;
                return a.diff - b.diff;
            }
        );

        for(int num:arr){
            pq.add(new Pair(Math.abs(num-x),num));
        }
    List<Integer> ans=new ArrayList<>();
        while(k>0){
          ans.add(pq.poll().val);
          k--;
        }
    Collections.sort(ans);
    return ans;
    }
}