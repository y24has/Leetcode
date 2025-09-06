class Solution {
    public int compress(char[] chars) {
     int left=0;
     int right=chars.length-1;

     int count =0;
     StringBuilder sb=new StringBuilder();

     while(left<=right){
        count=1;
        char ch=chars[left];
        while(left<right && chars[left+1]==ch){
            count++;
            left++;
        }
        sb.append(ch);
        if(count>1){
             sb.append(count);
             
     }
     left++;
     }
     
     for(int i=0;i<sb.length();i++){
       chars[i]=sb.charAt(i);
     }

     return sb.length();
    }
}