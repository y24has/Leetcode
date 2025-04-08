class Solution {
    public double findMaxAverage(int[] nums, int k) {
    
        
        double avg_value=Long.MIN_VALUE;
        double window_sum=0;

        for(int i=0;i<k;i++){
            window_sum+=nums[i];
        }
       double avg_value_1=window_sum/k;
        avg_value=Math.max(avg_value,avg_value_1);
        
        for(int i=k;i<nums.length;i++){
            window_sum+=nums[i]-nums[i-k];
            avg_value_1=window_sum/k;
            avg_value=Math.max(avg_value,avg_value_1);
        }
      return avg_value;
    }
}