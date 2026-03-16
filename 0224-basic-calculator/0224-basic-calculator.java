class Solution {
    public int calculate(String str) {
        Stack<Integer> s=new Stack<>();
        
        int result=0;
        int sign=1;
        int num=0;

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            if(ch=='+'||ch=='-'){
                result += sign * num;  
                num=0;
                sign=(ch=='+')?1:-1;
            }else if(ch=='('){
                s.push(result);
                s.push(sign);
                sign=1;
                num=0;
                result=0;
            }else if(ch==')'){
             result += sign * num;  
                num=0;
                result=s.pop()*result;
                result+=s.pop();
            }
        }
        result+=num*sign;
        return result;
    }
}