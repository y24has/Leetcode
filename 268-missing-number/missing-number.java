class Solution {
    public int missingNumber(int[] nums) {
   
        int i = 0;
        while (i < nums.length) {
        if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        } else {
            i++;
        }
    }

    for (int index = 0; index < nums.length; index++) {
        if (nums[index] != index) {
            return index;
        }
    }

    return nums.length;
    }
}