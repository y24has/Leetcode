class Solution {

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }

    public long countOfSubstrings(String word, int k) {
        return Math.abs(atLeast(word,k)-atLeast(word,k+1));
    }

    private Long atLeast(String word,int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int consonant = 0;
        long count = 0;

        for (int right = 0; right < word.length(); right++) {
            char ch = word.charAt(right);
            if (isVowel(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }else{
                consonant++;
            }

            while (map.size()==5&&consonant>=k){
                char leftChar=word.charAt(left);
                count+=word.length()-right;
                if(isVowel(leftChar)){
                    map.put(leftChar,map.getOrDefault(leftChar,0)- 1);
                    if(map.get(leftChar)==0) map.remove(leftChar);
                }else{
                    consonant--;
                }
                left++;
            }        
        }
        return count;
    }
}