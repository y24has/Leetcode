class Solution {
    public int minStartValue(int[] nums) {
        int prefixSum = 0;
        int minValue = 0;

        // "We're gonna do a for each loop"
        for (int num : nums) {
            prefixSum += num; // "traffic sum till the end"
            
            // "Check at each level which is the minimum value"
            minValue = Math.min(minValue, prefixSum);
        }

        // "Do 1 minus whatever the minimum value, then return that as ans"
        return 1 - minValue;
    }
}