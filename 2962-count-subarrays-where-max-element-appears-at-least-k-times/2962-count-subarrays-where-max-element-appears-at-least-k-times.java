class Solution {
    public long countSubarrays(int[] nums, int k) {
               int maxElement = 0;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        long totalSubarrays = 0;
        int countOfMax = 0;
        int left = 0;
        int n = nums.length;
        // Step 2: Standard Sliding Window
        for (int right = 0; right < n; right++) {
            // Add the right element to our window's state
            if (nums[right] == maxElement) {
                countOfMax++;
            }
            // Step 3: Your exact logic! 
            // When we reach K, we count the "future length" and shrink from the left.
            while (countOfMax == k) {
                // "The future length will also be considered"
                // Every array starting at 'left' and ending anywhere from 'right' to 'n-1' is valid.
                totalSubarrays += (n - right); 
                
                // "Shrinking from the left"
                // If the element we are leaving behind is our max element, decrement count
                if (nums[left] == maxElement) {
                    countOfMax--;
                }
                left++; // Shrink the window
            }
        }
        
        return totalSubarrays;
    }
}