class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words=text.split("\\s+");

        Set<Character> ch=new HashSet<>();

        for(int i=0;i<brokenLetters.length();i++){
            char c=brokenLetters.charAt(i);
            ch.add(c);
        }
        int res=0;
        for(int i=0;i<words.length;i++){
            String word=words[i];
            int cnt=0;
            for(int j=0;j<word.length();j++){
                if(ch.contains(word.charAt(j))){
                    break;
                }else{
                 cnt++;
                }
            }
            if(cnt==word.length())res++;
        }
        return res;
    }
}