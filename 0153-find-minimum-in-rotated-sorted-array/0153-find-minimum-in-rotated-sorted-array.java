class Solution {
    public int findMin(int[] nums) {
        int high=nums.length-1;
        int low=0;
        int N=nums.length;

        int mininum_element=-1;
        if (nums.length==0){
            return -1;
        }
        while(low<=high)
    {
        int mid=low+(high-low)/2;
        int prev=(mid+N-1)%N;
        int next=(mid+1)%N;
 
        if(nums[prev]>=nums[mid] && nums[next]>=nums[mid]){
            return nums[mid];
        }
        else if(nums[mid]>nums[high]){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
        return -1;
    }
}