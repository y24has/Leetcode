class Solution {
    public int maximumUniqueSubarray(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int currSum = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];

            // add right element
            map.put(val, map.getOrDefault(val, 0) + 1);
            currSum += val;

            // YOUR condition
            while (right - left + 1 > map.size()) {
                int leftVal = nums[left];
                map.put(leftVal, map.get(leftVal) - 1);
                currSum -= leftVal;

                if (map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }
                left++;
            }
            if(map.size()==right-left+1){
            maxSum = Math.max(maxSum, currSum);
         }
        } 

        return maxSum;
    }
}