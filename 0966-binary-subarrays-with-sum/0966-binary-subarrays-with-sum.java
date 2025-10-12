class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
    int count = 0,sum=0;           
        int n = nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1); // this coz [1,-1] and k=0 , we shd store a zero has first step as we are storing the cumulativesum in the map and cumulative sum starts from 0 we are doing tht  
        for (int i = 0; i < n; i++) {
            sum+=nums[i]; 
            if(map.containsKey(sum-goal)) {
                count+=map.get(sum-goal); 
            }   
             map.put(sum,map.getOrDefault(sum,0)+1);
            }
        return count;
    }
}