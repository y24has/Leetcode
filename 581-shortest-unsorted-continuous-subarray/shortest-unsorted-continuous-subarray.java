class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> s=new Stack<>();
        int left=nums.length;
        int right=0;
        int n=left;
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]>nums[i]){
                left=Math.min(s.pop(),left);
            }
            s.push(i);
        }
        s.clear();
        for(int j=n-1;j>=0;j--){
            while(!s.isEmpty() && nums[s.peek()]<nums[j]){
                right=Math.max(s.pop(),right);
            }
            s.push(j);
        }
        if(right-left+1>0){
            return right-left+1;
        }
        return 0;
    }
}