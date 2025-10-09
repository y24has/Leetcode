class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        String[] ans=s.trim().split("\\s+");

        for(int i=ans.length-1;i>=0;i--){
            sb.append(ans[i]).append(" ");
        }
        String result=sb.toString().trim();
        return result;
    }
}