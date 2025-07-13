
class Solution {
    public int minAddToMakeValid(String s) {
      // Stack<pair> s=new Stack<>();
       
       int open =0;
       int insertion=0;

       for(char ch:s.toCharArray()){
        if( ch=='('){
            open+=1;
        }
        else{
            if(open!=0){
                open--;
            }else{
                insertion++;
        }
        }
       }
       return open+insertion;
    }
}