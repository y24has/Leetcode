class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> p_map=new HashMap<>();
        Map<String,Character> s_map=new HashMap<>();

        String[] words = s.trim().split("\\s+");
        if (pattern.length() != words.length) return false;
        for(int i=0;i<pattern.length();i++){
            String w=words[i];
            char ch=pattern.charAt(i);

            if(p_map.containsKey(ch) && !p_map.get(ch).equals(w)) return false;
            if(s_map.containsKey(w) && !s_map.get(w).equals(ch))  return false;
            
            p_map.put(ch,w);
            s_map.put(w,ch);
        }
        return true;
    }
}