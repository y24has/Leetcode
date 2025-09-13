class StockSpanner {
    Stack<Integer> stack;
    int[] prices;
    int index;
    public StockSpanner() {
      stack=new Stack<>();
      prices = new int[100000];
      index=-1;
    }
    public int next(int price) {
      index++;
      prices[index]=price;
      while(!stack.isEmpty() &&prices[stack.peek()]<=price){
        stack.pop();
      }     
      int span=stack.isEmpty()?index+1:index-stack.peek();
      stack.push(index);
      return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */