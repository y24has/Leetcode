class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       long low=1;
       long high=0;
       for(int pile:piles){
        high=Math.max(pile,high);
       } 


       while(low<high){
        long mid=low+(high-low)/2;
        
        if(canFinish(piles,mid,h)){
            high=mid;
        }else{
            low=mid+1;
        }
       }
       return (int)low;
    }

    static boolean canFinish(int[] piles,long mid,int h){
        long count=0;
        for(int pile:piles){
           count+=(pile+mid-1)/mid;
           if(count>h) return false;
        }
        return count<=h;
    }
}