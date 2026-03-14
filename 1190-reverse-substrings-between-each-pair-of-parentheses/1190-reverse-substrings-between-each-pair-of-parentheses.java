class Solution {
    public String reverseParentheses(String string) {
        String str="";
        Stack<String> s=new Stack<>();
      
        for(char ch:string.toCharArray()){ 
            if(ch=='('){
               s.push(str);
               str="";          
            }else if(ch==')'){
              StringBuilder sb=new StringBuilder(str).reverse();
              str=sb.toString();
              if(!s.isEmpty()){
                str=s.pop()+str;
              } 
            }else{
                str+=ch;
            }
        }
        return str;
    }
}