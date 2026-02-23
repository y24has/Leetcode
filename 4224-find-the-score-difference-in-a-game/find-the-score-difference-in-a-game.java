class Solution {
    public int scoreDifference(int[] nums) {
        int first_player=0;
        int sec_player=0;
        boolean isFirst=true;
        for(int i=0;i<nums.length;i++){
              if(nums[i]%2!=0){
                isFirst=!isFirst;
              }
              if((i+1)%6==0){
                isFirst=!isFirst;
              }
              if(isFirst){
                 first_player+=nums[i];
              }else{
                sec_player+=nums[i];
              }
        }
        int ans=first_player-sec_player;
        return ans;
    }
}