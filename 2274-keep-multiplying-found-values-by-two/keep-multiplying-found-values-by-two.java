class Solution {
    public int findFinalValue(int[] nums, int original) {
        int left = 0;
        int n = nums.length;
        while (left < n) {
            if (nums[left] == original) {
                original *= 2;
                left = 0;      
            } else {
                left++;
            }
        }
        return original;
    }
}