class Solution {
    public boolean canPlaceFlowers(int[] nums, int n) {
        if(nums.length==1 && nums[0] == 0 && n==1 || n==0 ) return true;
      if(nums.length==1 && nums[0] == 0 && n==0 ) return false;
       for (int i = 0; i < nums.length; i++) {

        if (nums[i] == 0) {        
            if (i > 0 && i < nums.length - 1) {
                if (nums[i - 1] == 0 && nums[i + 1] == 0 && n > 0) {
                    nums[i] = 1;     
                    n--;             
                }
            }

            else if (i>0 && i == nums.length - 1) {
                if (nums[i - 1] == 0 && n > 0) {
                    nums[i] = 1;
                    n--;
                }
            }
            else if (i == 0) {
                if (nums[i + 1] == 0 && n > 0) {
                    nums[i] = 1;
                    n--;
                }
            }
        }
    }
    return n == 0;
    }
}