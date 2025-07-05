class Solution {
    public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) return false;
        Map<Character,Integer> s_map=new HashMap<>();
        Map<Character,Integer> t_map=new HashMap<>();

      
for(int i=0;i<s.length();i++){
    char  ch_s= s.charAt(i);
    s_map.put(ch_s, s_map.getOrDefault(ch_s, 0) + 1);   
    char  ch_t =t.charAt(i);
    t_map.put(ch_t, t_map.getOrDefault(ch_t, 0) + 1);
}


return s_map.equals(t_map);
    }
}