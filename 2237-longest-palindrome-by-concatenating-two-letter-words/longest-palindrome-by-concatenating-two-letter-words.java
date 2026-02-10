class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map=new HashMap<>();
        boolean flag=false;        
        int length=0;
        int n=words.length;
        for(String word:words){
            char ch1=word.charAt(0);
            char ch2=word.charAt(1);
            String rev = "" + word.charAt(1) + word.charAt(0);
            if(map.getOrDefault(rev,0)>0){
                length+=4;
                map.put(rev,map.getOrDefault(rev,0)-1);
                if(map.get(rev)==0) map.remove(rev);
            }else{
                map.put(word,map.getOrDefault(word,0)+1);
            }
        }

        for(String key:map.keySet()){
            if(key.charAt(0)==key.charAt(1)){
                flag=true;
                break;
            }
        }
        if(flag)length+=2;
        return length;
    }
}