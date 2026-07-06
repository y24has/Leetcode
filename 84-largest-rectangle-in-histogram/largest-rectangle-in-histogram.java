class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
        int[] leftSmall = new int[n];  // Stores NSL indices
        int[] rightSmall = new int[n]; // Stores NSR indices
        Stack<Integer> stack = new Stack<>();
        
        // 1. Find Next Smaller to Left (NSL) for every element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If stack is empty, there is no smaller element to the left. Boundary is -1.
            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear stack to reuse it for the right side
        stack.clear();
        
        // 2. Find Next Smaller to Right (NSR) for every element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If stack is empty, there is no smaller element to the right. Boundary is 'n'.
            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // 3. Calculate Area for each bar
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // Width = (Right Boundary Index) - (Left Boundary Index) - 1
            int width = rightSmall[i] - leftSmall[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea; 
    }
}