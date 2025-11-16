class Solution {
     static final int M = 1_000_000_007;
    public int numSub(String s) {
        long count=0;
        long subArrays=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1'){
                count++;
                subArrays=(subArrays+count)%M;
            }else{
                count=0;
            }
        }
        return (int)subArrays;
    }
}