class Solution {
    public long minimumSteps(String s) {
        long zero_count=0;
        int n=s.length();
        long swap=0;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch-'0'!=1){
               zero_count++;
            }else{
               swap+=zero_count;
            }
        }
        return swap;
    }
}