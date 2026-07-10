class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        if (k == 0) {
            return nums;
        }

        int windowSize = 2 * k + 1;
        if (windowSize > n) {
            return result;
        }

        long[] prefix = new long[n];
        prefix[0] =nums[0];

        for (int i =1; i <n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = k; i < n - k; i++) {
            int left = i - k;
            int right = i + k;

            long sum;
            if (left == 0) {
                sum = prefix[right];
            } else {
                sum = prefix[right] - prefix[left - 1];
            }

            result[i] = (int) (sum / windowSize);
        }

        return result;
    }
}