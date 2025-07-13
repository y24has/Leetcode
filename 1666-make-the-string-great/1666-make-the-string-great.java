class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(char ch:s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek()-ch)==32){
                stack.pop();
            }
            else{
                stack.add(ch);
            }
        }
        for (char ch : stack) {
        sb.append(ch);
    }
         return sb.toString();
    }
}