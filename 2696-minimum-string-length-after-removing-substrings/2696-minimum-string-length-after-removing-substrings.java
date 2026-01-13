class Solution {
    public int minLength(String s) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(!stack.isEmpty()){
                if(ch=='B' && stack.peek()=='A' ||ch=='D' && stack.peek()=='C'){
                stack.pop();
                }else{
                stack.push(ch);
            }
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}