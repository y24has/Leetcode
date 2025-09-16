class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s=new Stack<>();
        int n=temperatures.length;
        int[] result=new int[temperatures.length];
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            
            if(s.isEmpty()){
                res.add(0);
            }else if(!s.isEmpty() && temperatures[s.peek()]>temperatures[i]){
                  res.add(Math.abs(s.peek()-i));
            }
            else{
                while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                    s.pop();
                }
                if(s.isEmpty()){
                    res.add(0);
                }else{
                    res.add(Math.abs(s.peek()-i));
                }
            }
            s.add(i);
        }
        Collections.reverse(res);
        for (int i =0;i<n;i++) {
           result[i] = res.get(i);
      }
        return result;
    }
}