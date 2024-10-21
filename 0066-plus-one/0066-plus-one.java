class Solution {
    public int[] plusOne(int[] digits) {
        
     for(int i =digits.length-1;i>=0;i--) {
        digits[i]+=1;
        if(digits[i]<10)
      {        return digits;
      }
         digits[i]=0;
     }  
     int newdigit[]=new int[digits.length+1];
     newdigit[0]=1;
     return newdigit;
    }
}