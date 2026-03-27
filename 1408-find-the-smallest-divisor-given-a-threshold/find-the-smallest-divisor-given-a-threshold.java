class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 0, hi = 0;

        for (int num : nums) {
            hi = Math.max(hi, num);
        }

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (isValid(nums, mid, threshold)) {
                hi = mid;   // mid could be answer
            } else {
                lo = mid;   // mid is invalid
            }
        }

        return hi;
    }

    private boolean isValid(int[] nums, int d, int threshold) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + d - 1) / d; // ceil
            if(sum>threshold)return false;
        }

        return sum <= threshold;
    }
}