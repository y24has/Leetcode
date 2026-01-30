class Solution {
    public String smallestSubsequence(String s) {
        //if(s.length()==1)return s.charAt(0);
        Map<Character,Integer> map=new HashMap<>();
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Stack<Character> st=new Stack<>();
        Set<Character> set=new HashSet<>();
        
        st.push(s.charAt(0));
        set.add(s.charAt(0));
        map.put(s.charAt(0),map.get(s.charAt(0))-1);
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.get(ch)-1);
            if(set.contains(ch)) continue;
            while(!st.isEmpty() && st.peek()-ch>0 && map.get(st.peek())>0){
                    char removed = st.pop();
                    set.remove(removed);
                }
    
                  st.push(ch);
                  set.add(ch);
                }


        StringBuilder sb=new StringBuilder();
     for(int k=st.size()-1;k>=0;k--) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}