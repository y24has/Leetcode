class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
       int[] prefix=new int[words.length];

       for(int i=0;i<words.length;i++){
        String w=words[i];
        int l=0;
        int r=w.length()-1;
        if(isVowel(w.charAt(l)) && isVowel(w.charAt(r))){
            if(i==0){prefix[i]=1;}
            else{
                prefix[i]=prefix[i-1]+1;
            }
        } else {
                if (i == 0) prefix[i] = 0;
                else prefix[i] = prefix[i - 1];
       }
       }

       int[] res=new int[queries.length];
       int idx=0;
       for(int[] query:queries){
        int left=query[0];
        int right=query[1];
        if(left==0){
            res[idx]=prefix[right];
        }
        else{
          res[idx]=prefix[right]-prefix[left-1];
        }
        idx++;
       }
    return res;
    }

    private static boolean isVowel(char ch) {
    ch = Character.toLowerCase(ch);
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}
}