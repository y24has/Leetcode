class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int Min_index=Integer.MAX_VALUE;
        int Min_capacity=Min_index;

        for(int i=0;i<capacity.length;i++){
             if(capacity[i]>=itemSize &&capacity[i]<Min_capacity){
                Min_capacity=capacity[i];
                Min_index=i;
             }
        }
        return Min_index==Integer.MAX_VALUE?-1:Min_index;
    }
}