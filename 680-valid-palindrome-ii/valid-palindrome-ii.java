class Solution {
    public boolean validPalindrome(String s) {
       String cleaned = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        
        int left=0;
        int right=cleaned.length()-1;
        int count=0;
        while(left<right){

            if(cleaned.charAt(left)==cleaned.charAt(right)){
            left++;
            right--;
        }else{
              return isPalindrome(cleaned,left+1,right) || isPalindrome(cleaned,left,right-1);
        }
        }
        return true;
    }
  
  static Boolean isPalindrome(String cleaned,int lef,int rig){
    while(lef<rig){
         if(cleaned.charAt(lef)==cleaned.charAt(rig)){
            lef++;
            rig--;
         }else{
            return false;
         }
    }
    return true;
  }
}