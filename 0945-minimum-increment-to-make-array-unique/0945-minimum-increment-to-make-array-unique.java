class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        Arrays.sort(nums);
        int moves=0;
        int prev=nums[0];
        for(int i=1;i<n;i++){
            while(nums[i]<=prev){
                nums[i]++;
                moves++;
            }
            prev=nums[i];
        }
      return moves;
    }
}