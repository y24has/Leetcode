class Solution {
    public char findTheDifference(String s, String t) {
    
      HashMap<Character,Integer> S_map=new HashMap<>();
      HashMap<Character,Integer> T_map=new HashMap<>();

      for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        S_map.put(ch,S_map.getOrDefault(ch,0)+1);
      }
       for(int i=0;i<t.length();i++){
        char ch=t.charAt(i);
        T_map.put(ch,T_map.getOrDefault(ch,0)+1);
      }
      
      for(char ch : T_map.keySet()){
        //char Extra_ch=ch.getKey();
        int t_count=T_map.get(ch);
        int s_count=S_map.getOrDefault(ch,0);
        if(t_count>s_count) return ch;
      
    } 
       return ' ';  
    }
}