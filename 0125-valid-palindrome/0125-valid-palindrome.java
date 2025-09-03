class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]","");

        
        StringBuilder sb=new StringBuilder();
        for(int i=cleaned.length()-1;i>=0;i--){
            char ch=cleaned.charAt(i);  
              sb.append(ch);
        }
        return cleaned.equalsIgnoreCase(sb.toString());
    }
}