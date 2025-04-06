class Solution {
    public int fib(int n) {
      if(n==0) return 0;
      if(n==1) return 1;     
     //hypothesis
     int fibinacci=fib(n-1)+fib(n-2);
     
      //induction
  return fibinacci;    
    }
}