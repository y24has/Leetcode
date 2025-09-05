class Solution {
    public int mostWordsFound(String[] sentences) {
        

        int Max_words=0;
        for(int i=0;i<sentences.length;i++){
            String first =sentences[i];
            
            String[] part_parts=first.split(" ");
            
            Max_words=Math.max(part_parts.length,Max_words);
        }
        return Max_words;
    }
}