class Solution {
    public long countBadPairs(int[] nums) {
        long n=nums.length;
        long total_pairs=n*(n-1)/2;
        
        Map<Integer,Integer> map=new HashMap<>();
        long goodpairs=0;
        for(int i=0;i<n;i++){
            int pastLookup=nums[i]-i;

            if(map.containsKey(pastLookup)){
                 goodpairs+=map.get(pastLookup);
            }
            map.put(pastLookup,map.getOrDefault(pastLookup,0)+1);
        }
        return total_pairs-goodpairs;
    }
}