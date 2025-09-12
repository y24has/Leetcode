class Solution {
    public String removeStars(String s) {
     StringBuilder sb=new StringBuilder();
     Stack<Character> stack=new Stack<>();
     for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
          stack.push(ch);
        }
        else{
            stack.pop();
        }
     }
     while(!stack.isEmpty()){
        sb.append(stack.pop());
     }
     return sb.reverse().toString();
    }
}