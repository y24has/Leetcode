class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
 
     int left=0;
     int right=0;
     int sum=0;
     int count=0;
     int cnt_zeros=0;
     for(right=0;right<nums.length;right++){
        sum+=nums[right];
        while(left<right && (nums[left]==0 ||sum>goal)){
            if(nums[left]==0){
                cnt_zeros++;
            }else{
                cnt_zeros=0;
            }
            sum-=nums[left];
            left++;
        }
        if(sum==goal){ 
            count+=1;
            count+=cnt_zeros;
        }
     }
     return count;
    }
}