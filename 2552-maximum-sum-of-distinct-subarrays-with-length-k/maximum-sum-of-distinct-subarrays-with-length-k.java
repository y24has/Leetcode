class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum=0;
        long Maxsum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum+=nums[i];
        }
        if (map.size() == k) {  // Ensure all elements are distinct in the first window
        Maxsum = Math.max(sum, Maxsum);
}
        for(int i=k;i<nums.length;i++){
           int toremove=nums[i-k];
           map.put(toremove, map.getOrDefault(toremove, 0) - 1);
           if(map.get(toremove)==0){
              map.remove(toremove);
           }
           int toAdd=nums[i];
           map.put(toAdd, map.getOrDefault(toAdd,0)+1);
            sum+=nums[i]-nums[i-k]; 
           if(map.size() == k){
            Maxsum=Math.max(sum,Maxsum);
        }
        }
      return Maxsum;
    }
}