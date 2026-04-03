class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       
        List<Integer> res = new ArrayList<>();

       int i=0;
       while (i < nums.length) {
            int correct = nums[i] - 1;

            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                res.add(nums[index]);
            }
        }


    return res;
    }

}
