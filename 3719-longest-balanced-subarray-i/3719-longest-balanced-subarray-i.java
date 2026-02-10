class Solution {
    public int longestBalanced(int[] nums) {
        
        int count=0;
        for(int left=0;left<nums.length;left++){
            Set<Integer> pos=new HashSet<>();
            Set<Integer> neg=new HashSet<>();
          for(int right=left;right<nums.length;right++){
             if(nums[right]%2==0){
                pos.add(nums[right]);
             }else{
                neg.add(nums[right]);
             }

             if(pos.size()==neg.size()){
                count=Math.max(count,right-left+1);
             }
          }
        }
        return count;
    }
}