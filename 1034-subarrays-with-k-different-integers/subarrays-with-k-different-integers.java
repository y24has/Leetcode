class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
     int count_k=atMost(nums,k);
     int count_k_1=atMost(nums,k-1);
     return Math.abs(count_k-count_k_1);
    } 
    private static int atMost(int[] nums,int k){
        int n=nums.length;
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           
            while(map.size()>k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            count += (j - i + 1);
        }
        return count;
 }
}