class Solution {
    public int maxWidthRamp(int[] nums) {
        int max_wid=0;
        Stack<Integer> s=new Stack<>();
        s.push(0);
        for(int i=1;i<nums.length;i++){
           if(nums[s.peek()]>nums[i]){
             // s.pop();
              s.push(i);
           }
        }
      for(int right=nums.length-1;right>=0;right--){
            while(!s.isEmpty() && nums[right]>=nums[s.peek()]){
              max_wid=Math.max(max_wid,right-s.peek());
              s.pop();
            }
        }
      return max_wid;
    }
}