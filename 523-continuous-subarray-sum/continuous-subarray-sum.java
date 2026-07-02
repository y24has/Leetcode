class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Remainder 0 is considered to occur before the array starts
        map.put(0, -1);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = (int) (sum % k);
            // If negatives are allowed, use:
            // rem = (rem + k) % k;
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                // Store only the first occurrence
                map.put(rem, i);
            }
        }
        return false;
    }
}