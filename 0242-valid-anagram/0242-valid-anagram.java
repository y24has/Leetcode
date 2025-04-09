class Solution {
    public boolean isAnagram(String s, String t) {
    HashMap<Character,Integer> freq_s=new HashMap<>();
    HashMap<Character,Integer> freq_t=new HashMap<>();    
      s=s.toLowerCase();
      t=t.toLowerCase();
      for(char ch: s.toCharArray()){
       freq_s.put(ch,freq_s.getOrDefault(ch,0)+1);
      }


      for(char ch:t.toCharArray()){
       freq_t.put(ch,freq_t.getOrDefault(ch,0)+1);
      }

       return (freq_s.equals(freq_t))?true:false;
    }
}