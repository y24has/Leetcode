class Solution {
    public int arrangeCoins(int n) {
        int staircase_cnt=0;
        int coins=n;

        for(int i=0;i<n;i++){
            if(coins>=i+1){
                staircase_cnt+=1;
                coins-=i+1;
            }else{
                break;
            }
        }
        return staircase_cnt;
    }
}