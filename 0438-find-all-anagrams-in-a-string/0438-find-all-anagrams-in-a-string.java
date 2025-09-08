class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        Map<Character,Integer> map_s=new HashMap<>();
        Map<Character,Integer> map_p=new HashMap<>();
        if (s.length() < p.length()) {
    return list; // no anagrams possible if s is shorter than p
}

        int k=p.length();
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(map_s.containsKey(ch)){
                map_s.put(ch,map_s.get(ch)+1);
            }
            else{
                map_s.put(ch,1);
            }
        }
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            if(map_p.containsKey(ch)){
                map_p.put(ch,map_p.get(ch)+1);
            }
            else{
                map_p.put(ch,1);
            }
        }
        if(map_s.equals(map_p)) {
            list.add(0);
            }
        for(int i=k;i<s.length();i++){
            char toremove=s.charAt(i-k);
             map_s.put(toremove,map_s.getOrDefault(toremove , 0)-1);

             if(map_s.get(toremove)==0){
                map_s.remove(toremove);
             }
             char toAdd=s.charAt(i);
             map_s.put(toAdd,map_s.getOrDefault(toAdd,0)+1);

             if(map_s.equals(map_p)) {
            list.add(i-k+1);
            }
        }   
    return list;
    }
}