class Solution {
    public int lengthOfLongestSubstring(String s) {
       int max_len=0;
       int left=0;
       int right=0;
       int len=0;

       Map<Character,Integer> map=new HashMap<>();
       while(right<s.length()){
        char ch=s.charAt(right);    
        map.put(ch,map.getOrDefault(ch,0)+1);

        while(map.get(ch)>1){
          char left_char=s.charAt(left); 
          map.put(left_char,map.get(left_char)-1);
          if(map.get(left_char)==0) map.remove(left_char);
          left++;
        }
         max_len=Math.max(right-left+1,max_len);
         right++;
       } 
    return max_len;
    }
}