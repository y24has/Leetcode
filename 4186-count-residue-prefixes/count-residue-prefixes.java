class Solution {
    public int residuePrefixes(String s) {
        int count=0;
        Set<Character> set=new HashSet<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            set.add(ch);
            if(set.size()==(i+1)%3){
                count++;
            }
        }
        return count;
    }
}