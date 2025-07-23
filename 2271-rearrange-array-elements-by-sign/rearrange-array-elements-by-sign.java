class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> s_pos = new LinkedList<>();
        Queue<Integer> s_neg = new LinkedList<>();


        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                s_neg.add(nums[i]);
            }else{
                s_pos.add(nums[i]);
            }
        }

        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=s_pos.poll();
            }else{
                nums[i]=s_neg.poll();
            }
        }
     return nums;
  }
}