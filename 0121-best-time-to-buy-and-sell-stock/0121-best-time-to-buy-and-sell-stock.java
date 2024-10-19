class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
          if(prices[i]<=minPrice){
           minPrice = prices[i];
          }
        
        int potentialprofit=prices[i]-minPrice;
        if(potentialprofit>maxProfit){
            maxProfit = potentialprofit;
        }
        }
        return maxProfit;
    }
}