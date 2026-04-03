class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();

         int i = 0;

    while (i < nums.length) {
        if (nums[i] != nums[nums[i]-1]) {
            int correct=nums[i]-1;
            int temp = nums[i];
            nums[i] = nums[correct];
            nums[correct]=temp;
        } else {
            i++;
        }
    }

    for (int index = 0; index < nums.length; index++) {
        if (nums[index] != index+1) {
            ans.add(index+1);
        }
    }
        return ans;       
    }
}