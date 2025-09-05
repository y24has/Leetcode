class Solution {
    public String restoreString(String s, int[] indices) {
       char[] res=new char[s.length()];
       char[] string=s.toCharArray();
       for(int i=0;i<indices.length;i++){
         res[indices[i]]=string[i];
       }
    return new String(res);
    }
}