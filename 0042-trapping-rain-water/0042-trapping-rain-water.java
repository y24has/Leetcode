class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] ngleft=new int[n];
         int[] ngright=new int[n];
         ngleft[0]=height[0];
         for(int i=1;i<n;i++){
            ngleft[i]=Math.max(ngleft[i-1],height[i]);
         }
         ngright[n-1]=height[n-1];
         for(int i=n-2;i>=0;i--){
            ngright[i]=Math.max(ngright[i+1],height[i]);
         }
         int water=0;
          int left=0,right=n-1;
          for(int i=0;i<n;i++){
           water+=Math.min(ngleft[i],ngright[i])-height[i];
         }
         return water;
    }
}