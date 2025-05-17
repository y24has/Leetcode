class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map_s2=new HashMap<>();
         Map<Character,Integer> map_s1=new HashMap<>();
         if(s2.length()<s1.length()) return false;
         int k=s1.length();
          for(int i=0;i<k;i++){
            char ch=s2.charAt(i);
            map_s2.put(ch,map_s2.getOrDefault(ch,0)+1);
          }
          for(int i=0;i<k;i++){
            char ch=s1.charAt(i);
            map_s1.put(ch,map_s1.getOrDefault(ch,0)+1);
          }
    if (map_s1.equals(map_s2)) return true;
     
     for(int i=k;i<s2.length();i++){
        char toremove=s2.charAt(i-k);
        map_s2.put(toremove,map_s2.getOrDefault(toremove,0)-1);
        if(map_s2.get(toremove)==0){
           map_s2.remove(toremove);
        }
        char toAdd=s2.charAt(i);
        map_s2.put(toAdd,map_s2.getOrDefault(toAdd,0)+1);
       
        if (map_s1.equals(map_s2)) return true;
    }
     return false;
    }
}