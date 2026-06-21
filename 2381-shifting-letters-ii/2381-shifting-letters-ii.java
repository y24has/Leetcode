class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();

        int[] diff_array=new int[n+1];

        for(int[] shift:shifts){
            int from=shift[0];
            int to=shift[1];
            int operation=shift[2];

            if(shift[2]==0){
                diff_array[from]-=1;
                diff_array[to+1]+=1;
            }else{
                diff_array[from]+=1;
                diff_array[to+1]-=1;
            }
        }
        for(int i=1;i<diff_array.length;i++){
            diff_array[i]+=diff_array[i-1];
        }
         
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<diff_array.length-1;i++){
            int shift=diff_array[i]%26;
            char ch=s.charAt(i);
            int newPosition=(ch-'a'+shift+26)%26;
            sb.append((char)('a'+newPosition));
        }
         return sb.toString();
    }
}