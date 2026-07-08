class Solution {
    public int maximumScore(int[] nums, int k) {
          int n = nums.length;
        
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // Pass 1: Find Next Smaller to Left (NSL)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear(); // Reset stack for the right side
        
        // Pass 2: Find Next Smaller to Right (NSR)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
     
        int maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            int left = leftSmall[i];
            int right = rightSmall[i];
            
            // Your exact "if condition"!
            // The subarray spans from (left + 1) to (right - 1).
            // For 'k' to be inside this subarray, left must be < k, and right must be > k.
            if (left < k && right > k) {
                
                // Calculate length: (Right Boundary) - (Left Boundary) - 1
                int length = right - left - 1;
                
                // Score = minimum value * length
                int score = nums[i] * length;
                
                maxScore = Math.max(maxScore, score);
            }
        }
        
        return maxScore;
    }
}