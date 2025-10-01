class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            char ch=sentence.charAt(i);
            if(ch>='a' && ch<='z'){
                set.add(ch);
            }
        }
        return set.size()==26;

    }
}