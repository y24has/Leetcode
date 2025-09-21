class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
           if ((long)m * k > bloomDay.length) return -1;

        int  low=Integer.MAX_VALUE;
        int high=0;
        for(int day:bloomDay){
            low=Math.min(day,low);
            high=Math.max(day,high);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(checkBouquets(bloomDay,mid,m,k)){
               ans=mid;
               high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    static boolean checkBouquets(int[] bloomDay,int mid, int m, int k){
        int count=0;
        long bouquets=0;
        for(int day:bloomDay){
            if(day<=mid){
                count++;
                if(count==k){
                    count=0;
                    bouquets++;
                }
            }else{
             count=0;
            }
        }
        return bouquets>=m;
    }
}