class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        
        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int point : cardPoints) {
            totalSum += point;
        }
          if (n == k)return totalSum;
        // Step 2: Size of leftover subarray
        int windowSize = n - k;

        // Step 3: Sum of first window
        int currentWindowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currentWindowSum += cardPoints[i];
        }

        // Initially, first window is the minimum
        int minWindowSum = currentWindowSum;

        // Step 4: Slide the window
        for (int right = windowSize; right < n; right++) {

            // Remove leftmost element
            currentWindowSum -= cardPoints[right - windowSize];

            // Add new right element
            currentWindowSum += cardPoints[right];

            // Update minimum window sum
            minWindowSum = Math.min(minWindowSum, currentWindowSum);
        }

        // Step 5: Maximum score
        return totalSum - minWindowSum;
    }
}