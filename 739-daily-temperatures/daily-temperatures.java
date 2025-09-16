class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> s = new ArrayDeque<>();
        int n=temperatures.length;
        int[] result=new int[n];
        for(int i=n-1;i>=0;i--){
                while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    result[i]=0;
                }else{
                    result[i]=s.peek()-i;
                }
            s.push(i);
        }
        return result;
    }
}