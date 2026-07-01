class Solution {
    public int minSubarray(int[] nums, int p) {
      
      HashMap<Integer,Integer> map=new HashMap<>();
      long ttl_sum=0;
      for(int num:nums){
        ttl_sum+=num;
      }
      int diff=(int)(ttl_sum%p);
      if(diff==0) return 0;
      int sum=0;
      map.put(0,-1);
      int minLen=nums.length;
      for(int i=0;i<nums.length;i++){
      sum=(sum+nums[i])%p;
      int lookup=(sum-diff+p)%p;
      if(map.containsKey(lookup)){
        minLen=Math.min(minLen,i-map.get(lookup));
      }
        map.put(sum,i);
    }
    return minLen == nums.length ? -1 : minLen;
    }
}