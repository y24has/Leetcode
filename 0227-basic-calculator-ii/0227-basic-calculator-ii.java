class Solution {
    public int calculate(String t) {
        Stack<Integer> s=new Stack();
        int num=0;

        char prevop='+';
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(String.valueOf(ch).matches("[0-9]")) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == t.length() - 1) {
            if(prevop=='+'){
              s.push(num);
            }else if(prevop=='-'){
                s.push(-num);
            }else if(prevop=='*'){
              s.push(s.pop()*num);
            }else if(prevop=='/'){
               s.push(s.pop()/num);
            }
            prevop=ch;
            num=0;
        }
        }
        int result=0;
        while(!s.isEmpty()){
        result+=s.pop();
        }
        return result;
    }
}