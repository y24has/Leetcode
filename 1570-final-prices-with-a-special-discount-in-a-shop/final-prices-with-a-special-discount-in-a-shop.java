class Solution {
    public int[] finalPrices(int[] prices) {
       int[] result=new int[prices.length];
       Stack<Integer> stack=new Stack<>();
       int n=prices.length;
       for(int i=n-1;i>=0;i--){
          
            while(!stack.isEmpty() && stack.peek()>prices[i]){
                stack.pop();
            }
             if(!stack.isEmpty()){
               result[i]=Math.abs(prices[i]-stack.peek());
            }
           else{
            result[i]=prices[i];
           }
           stack.push(prices[i]);
       }
        return result;
    }
}