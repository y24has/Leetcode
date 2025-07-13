class Solution {
    public String removeDuplicates(String s) {
     Stack<Character> result=new Stack<>();  
     for(char c:s.toCharArray()){
         if(!result.isEmpty() &&result.peek()==c){
            result.pop();
        }
        else{
            result.push(c);
        }
     }

     StringBuilder finalResult= new StringBuilder();
     while(!result.isEmpty()){
        finalResult.append(result.pop());
     }
     return finalResult.reverse().toString();
    }
}