class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int result=0;

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(map.get(ch)==2){
            result+=2;
            map.remove(ch);
            }
        }
        if(map.size()!=0){
            result+=1;
        }
        return result;
    }
}