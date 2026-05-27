class Solution {
    public String clearStars(String s) {
        int n=s.length();

        int[] Deleated=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; 
            }
            return a[0] - b[0];     
        });
        
        for(int i=0;i<n;i++){
          char ch=s.charAt(i);

          if(ch=='*'){
            int RightmostCh=pq.peek()[1];
            pq.poll();
            Deleated[RightmostCh]=1;
            Deleated[i]=1;
          }else{
            pq.offer(new int[]{ch,i});
          }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(Deleated[i]!=1){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}