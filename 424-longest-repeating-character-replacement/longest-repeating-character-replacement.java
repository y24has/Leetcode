class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen=0;
        int left=0,right=0;
        int maxFreq=0;
        Map<Character,Integer> map=new HashMap<>();
        for(right=0;right<s.length();right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(map.get(ch),maxFreq);
            while((right-left+1)-maxFreq > k){
                char toRemv=s.charAt(left);
                map.put(toRemv,map.get(toRemv)-1);
                if(map.get(toRemv)==0)map.remove(toRemv);
                left++;
            }
            maxLen=Math.max(right-left+1,maxLen);
        }
        return  maxLen;
    }
}