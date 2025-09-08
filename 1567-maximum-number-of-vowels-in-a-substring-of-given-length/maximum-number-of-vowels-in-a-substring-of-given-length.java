class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int count=0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
        if(vowels.contains(s.charAt(i))){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            count+=1;
        }
        }
        int Max_cnt=count;

        for(int i=k;i<s.length();i++){
           char left = s.charAt(i - k);
           char right = s.charAt(i);
            if(map.containsKey(left)){
                map.put(left,map.get(left)-1);
                count--;
                if(map.get(left)==0) map.remove(s.charAt(i-k));
            }
            if(vowels.contains(right)){
            map.put(right,map.getOrDefault(right,0)+1);
            count++;
        }
           Max_cnt=Math.max(count,Max_cnt);
        }
        return Max_cnt;    
    }
}