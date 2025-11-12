class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       long low=-1;
       long high=0;
       for(int pile:piles){
        high=Math.max(pile,high);
       } 
        high+=1;

       while(low+1<high){
        long mid=low+(high-low)/2;

        if(canFinish(piles,mid,h)){
            high=mid;
        }else{
            low=mid;
        }
       }
       return (int)high;
    }

    static boolean canFinish(int[] piles,long mid,int h){
        if (mid <= 0) return false;
        long count=0;
        for(int pile:piles){
        count += Math.ceil((double)pile / mid);

           if(count>h) return false;
        }
        return count<=h;
    }
}