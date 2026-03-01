class Solution {
    public String mergeCharacters(String s, int k) {
      while(true){
      boolean merged=false;

         for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==(s.charAt(j)) && (j-i)<=k){
                   s=s.substring(0,j)+s.substring(j+1);
                   merged=true;
                   break;
                }
            }
            if(merged) break;
         }
        if(!merged) break;
      }
      return s;
    }
}