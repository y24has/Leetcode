class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int o_idx=0;
        int t_idx=0;
        Stack<Integer> s=new Stack<>();

        while(o_idx<pushed.length && t_idx<popped.length){
            if(pushed[o_idx]!=popped[t_idx]){
                s.push(pushed[o_idx]);
                o_idx++;
            }
            else{
                s.push(pushed[o_idx]);
                s.pop();
                o_idx++;
                t_idx++;
                       while(!s.isEmpty() && s.peek() == popped[t_idx]){
                s.pop();
                t_idx++;
                }
            }
            // while(!s.isEmpty() && s.peek() == popped[t_idx]){
            //  s.pop();
            //  j++;
        }
        
     return  (s.isEmpty() && t_idx==popped.length);
    }
}