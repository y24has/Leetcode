class Solution {
    public String largestMerge(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();

        StringBuilder sb=new StringBuilder();
        int w1=0,w2=0;
        while( w1<n1 && w2<n2){
            if(word1.substring(w1).compareTo(word2.substring(w2))>=0){
                sb.append(word1.charAt(w1++));
            }else{
                sb.append(word2.charAt(w2++));
            }
        }
        while(w1<n1)sb.append(word1.charAt(w1++));
        while(w2<n2)sb.append(word2.charAt(w2++));
        return sb.toString();
    }
}