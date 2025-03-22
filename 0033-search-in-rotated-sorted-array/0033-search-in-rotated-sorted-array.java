class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int N = nums.length;
        int low = 0;
        
        // Step 1: Find the Pivot (Smallest Element Index)
        int index = findMinimumIndex(nums, low, high);
        
        // Step 2: Search in both halves
        int element = binary_search(nums, low, index - 1, target);
        int element2 = binary_search(nums, index, high, target);
        
        // Step 3: Return the found index or -1
        return (element != -1) ? element : element2;
    }

    public static int findMinimumIndex(int[] nums, int low, int high) {
        int N = nums.length;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + N - 1) % N;
            int next = (mid + 1) % N;
            
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return mid;
            }
            if (nums[mid] <= nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binary_search(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
