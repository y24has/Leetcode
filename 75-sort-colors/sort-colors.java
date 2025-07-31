class Solution {
    public void sortColors(int[] nums) {
       int i=0;
        int j=0;
        int k=nums.length-1;

        while(j<=k){
            if(nums[j]==0){
                swap(i,j,nums);
                i++;
                j++;
            }
            else if(nums[j]==1){
                j++;
            }
            else if(nums[j]==2){
                swap(j,k,nums);
                k--;
            }
        }
    }

    static void swap(int n1,int n2,int[] nums){
     int temp=nums[n1];
     nums[n1]=nums[n2];
     nums[n2]=temp;
    }
}