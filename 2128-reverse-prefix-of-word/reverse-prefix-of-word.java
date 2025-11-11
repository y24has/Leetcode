class Solution {
    public String reversePrefix(String word, char ch) {
        int idx=-1;

        for(int i=0;i<word.length();i++){
            char ltr=word.charAt(i);
            if(ltr==ch){
              idx=i;
              break;
            }
        }
        if(idx==-1) return word;

        String newWord=word.substring(0,idx+1);

        StringBuilder sb=new StringBuilder();
        for(int i=newWord.length()-1;i>=0;i--){
            char ltr=newWord.charAt(i);
            sb.append(ltr);
        } 
        sb.append(word.substring(idx+1));
        return sb.toString();
    }
}