class Solution {
    public int waysToMakeFair(int[] nums) {
        int TotalEvn=0;
        int TotalOdd=0;
        int j=0;
        while(j<nums.length){
           if(j%2==0){
            TotalEvn+=nums[j];
           }else{
            TotalOdd+=nums[j];
           }
           j++;
        }

        int leftEvn=0,leftOdd=0;
        int fairCount=0;
        for(int i=0;i<nums.length;i++){
           int RightEvn = 0;
            int RightOdd = 0;
           if(i%2==0){
           RightEvn=TotalEvn-leftEvn-nums[i];
           RightOdd=TotalOdd-leftOdd;
           }else{
           RightOdd=TotalOdd-leftOdd-nums[i];
           RightEvn=TotalEvn-leftEvn;
           }

           if (leftEvn + RightOdd == leftOdd + RightEvn) {
                fairCount++;
            }
    
            if (i % 2 == 0) {
                leftEvn += nums[i];
            } else {
                leftOdd += nums[i];
            }
        }
       return fairCount;
    }
}