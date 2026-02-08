class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
     Deque<Long> s = new ArrayDeque<>();
        
        for(int i=0;i<nums.length;i++){
            long curr=nums[i];
            while(!s.isEmpty() && s.peek()==curr){
             curr+=s.pop();
            } 
            s.push(curr);
        }
        List<Long> ans=new ArrayList<>();
        while(!s.isEmpty()){
            ans.add((long)s.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}