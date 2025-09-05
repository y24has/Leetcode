class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();

        String s1=s.substring(0,n/2);
        String s2=s.substring(n/2,n);
        
        Map<Character,Integer> s1_map=new HashMap<>();
        Map<Character,Integer> s2_map=new HashMap<>(); 

        for(char ch:s1.toCharArray()){
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                 s1_map.put(ch,s1_map.getOrDefault(ch,0)+1);      
         }
        }

          for(char ch:s2.toCharArray()){
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                 s2_map.put(ch,s2_map.getOrDefault(ch,0)+1);      
         }
          }

          String vowels = "aeiouAEIOU";
          char[] vowelArr = vowels.toCharArray();

           int count1 = 0, count2 = 0;

       for (char ch : vowelArr) {
          if (s1_map.containsKey(ch)) {
        count1 += s1_map.get(ch);
         }
          if (s2_map.containsKey(ch)) {
        count2 += s2_map.get(ch);
         }
}
if(count1!=count2) return false;
      return true;
      }
}
