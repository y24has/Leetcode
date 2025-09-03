class Solution {
    public int maxPower(String s) {
        int power=1;
        int count=1;
        for(int i=0;i<s.length();i++){
           if(i>0 &&s.charAt(i)==s.charAt(i-1)){
              count++;
              power=Math.max(power,count);
           }else{
            count=1;
           }
      
        }
      return power;
    }
}