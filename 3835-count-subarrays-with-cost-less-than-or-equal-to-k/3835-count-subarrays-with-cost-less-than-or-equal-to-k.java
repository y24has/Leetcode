class Solution {
    public long countSubarrays(int[] nums, long k) {
       TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0;
        long ans = 0;
        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while ((long)(map.lastKey() - map.firstKey()) * (r - l + 1) > k) {
                int leftVal = nums[l];
                map.put(leftVal, map.get(leftVal) - 1);
                if (map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }
                l++;
            }
            ans += (r - l + 1);
        }

        return ans; 
    }
}