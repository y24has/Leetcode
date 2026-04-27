class Solution {
    public long[] distance(int[] nums) {
      int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> list : map.values()){
            long[] prefix=new long[list.size()];
            prefix[0]=list.get(0);
            for(int i=1;i<prefix.length;i++){
                prefix[i]=prefix[i-1]+list.get(i);
            }

            for(int i=0;i<list.size();i++){
                int idx=list.get(i);

                long left=(long)i*idx-(i>0?prefix[i-1]:0);
                long right= (prefix[list.size()-1]-prefix[i])-(long)(list.size()-i-1)*idx;
                 res[idx] = left+right;
            }
        }
        return res;  
    }
}