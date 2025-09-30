class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        int j=0;
        boolean flag=true;
        String concat=word1+word2;
        while(i<word1.length() || j<word2.length()){
            if(flag){
                if(i<word1.length()){
                sb.append(word1.charAt(i));
                }
                flag=false;
                i++;
            }else{
                if(j<word2.length()){
                sb.append(word2.charAt(j));
                }
                flag=true;
                j++;
            }
        }
        return sb.toString();
    }
}