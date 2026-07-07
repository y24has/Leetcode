class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long maxProduct = 0;
        for (int i = 0; i < n; i++) {
            int left = leftSmall[i];
            int right = rightSmall[i];
            
            long subarraySum = prefix[right] - prefix[left + 1];
            long product = (long) nums[i] * subarraySum;
            maxProduct = Math.max(maxProduct, product);
        }
        return (int)(maxProduct % 1000000007);
    }
}