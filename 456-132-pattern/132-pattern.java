class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length==0 || nums.length<3)return false;
        
        Stack<Integer> s=new Stack<>();
        int min_val=Integer.MIN_VALUE;
        
        for(int i=nums.length-1;i>=0;i--){
           if(nums[i]<min_val){
            return true;
           }

           while(!s.isEmpty()&&nums[i]>s.peek()){
            min_val=s.pop();
           }
           s.push(nums[i]);
        }
        return false;
    }
}