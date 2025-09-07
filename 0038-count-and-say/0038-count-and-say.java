class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        StringBuilder sb=new StringBuilder();
        String say_cnt=countAndSay(n-1);
        
        for(int i=0;i<say_cnt.length();i++){
            int count=1;
            char ch=say_cnt.charAt(i);

            while(i<say_cnt.length()-1 && say_cnt.charAt(i)==say_cnt.charAt(i+1)){
                count++;
                i++;
            }
            
            sb.append(count).append(ch);
        }
         return sb.toString();
    }
}