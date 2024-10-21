class Solution {
    public boolean isMonotonic(int[] nums) {
         boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false; // Found a decrease
            }
            if (nums[i] < nums[i + 1]) {
                isDecreasing = false; // Found an increase
            }
        }

        return isIncreasing || isDecreasing; 
    }
}