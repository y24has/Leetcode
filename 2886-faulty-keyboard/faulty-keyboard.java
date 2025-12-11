class Solution {
    public String finalString(String s) {
        StringBuilder sb=new StringBuilder();
        String str=s;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='i'){
                sb.reverse();
            }else{
                 sb.append(ch);
            }
        }
        return sb.toString();
    }
}