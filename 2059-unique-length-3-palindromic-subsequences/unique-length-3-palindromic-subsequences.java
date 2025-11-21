class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> UniqueChars=new  HashSet<>();
        
        int result=0;
        for(char ch:s.toCharArray()){
        UniqueChars.add(ch);
        }
       
        for(char ch:UniqueChars){
        int leftside=-1;
        int rightside=-1;
          for(int i=0;i<s.length();i++){
                if(s.charAt(i)==ch){
                    if(leftside==-1){
                        leftside=i;
                    }
                    rightside=i;
                }
            }
        Set<Character> ltr=new HashSet<>();
        for(int j=leftside+1;j<rightside;j++){
        ltr.add(s.charAt(j));
        }
        result+=ltr.size();
        }
        return result;
    }
}