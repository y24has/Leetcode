class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            long len=right-left+1;
            long  score=sum*len;
            while (score >= k) {
                sum -= nums[left];
                left++;
                len=(right-left+1);
                 score=sum*len;
            }

            count += (right - left + 1);
        }

        return count;
    }
}