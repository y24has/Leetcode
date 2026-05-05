class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
            return atMost(nums, k) - atMost(nums, k - 1);
}

private int atMost(int[] nums, int k) {
    int left = 0, count = 0, oddCount = 0;

    for (int right = 0; right < nums.length; right++) {

        // if odd
        if (nums[right] % 2 == 1) {
            oddCount++;
        }

        // shrink window if more than k odds
        while (oddCount > k) {
            if (nums[left] % 2 == 1) {
                oddCount--;
            }
            left++;
        }

        // number of valid subarrays ending at right
        count += (right - left + 1);
    }

    return count;
    }
}