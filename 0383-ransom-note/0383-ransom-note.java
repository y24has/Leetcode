class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       Map<Character, Integer> R_freq = new HashMap<>();
        Map<Character, Integer> M_freq = new HashMap<>();
        for(char ch:magazine.toCharArray()){
            M_freq.put(ch, M_freq.getOrDefault(ch, 0) + 1);
          }
          for(char ch:ransomNote.toCharArray()){
             R_freq.put(ch, R_freq.getOrDefault(ch, 0) + 1);
                    if(!M_freq.containsKey(ch) || M_freq.get(ch)<R_freq.get(ch)){
                return false;
             }
          }
     return true;
    }
}