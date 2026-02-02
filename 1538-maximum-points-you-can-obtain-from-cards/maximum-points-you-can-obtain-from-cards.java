class Solution {
    public int maxScore(int[] cardPoints, int g_k) {
        int n=cardPoints.length;
        if(n==g_k){
            int sum=0;
            for(int val:cardPoints) sum+=val;
            return sum;
        }
        int total_sum=0;
        for(int ele:cardPoints){
            total_sum+=ele;
        }
        int k=n-g_k;
        int win_sum=0;
        for(int i=0;i<k;i++){
            win_sum+=cardPoints[i];
        }
        int sum=win_sum;
        for(int j=k;j<n;j++){
            sum-=cardPoints[j-k];
            sum+=cardPoints[j];
            if(sum<win_sum){
                win_sum=sum;
            }
        }
        return total_sum-win_sum;
    }
}