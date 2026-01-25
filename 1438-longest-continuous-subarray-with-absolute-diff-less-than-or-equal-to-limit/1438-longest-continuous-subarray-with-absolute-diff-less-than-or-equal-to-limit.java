class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            int distance = map.lastKey() - map.firstKey();
            while (distance > limit) {
                int val = nums[left];
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) {
                    map.remove(val);
                }
                left++;
                distance = map.lastKey() - map.firstKey();
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}