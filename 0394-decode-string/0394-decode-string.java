class Solution {
    public String decodeString(String s) {
        Stack<String> s_str=new Stack<>();
        Stack<Integer> s_num=new Stack<>();
        int k=0;
        String str="";
        for(char c:s.toCharArray()){
           if(Character.isDigit(c)){
            k=k*10+(c-'0');
           }else if(c=='['){
            s_num.push(k);
            s_str.push(str);
            k=0;
            str="";
           }else if(c==']'){
            int reptym=s_num.pop();
            String lastStr=s_str.pop();
            StringBuilder sb=new StringBuilder(lastStr);
            for(int i=0;i<reptym;i++){
                sb.append(str);
            }
            str=sb.toString();

           }else if(Character.isLetter(c)){
            str+=c;
           }
        }
        return str;
    }
}