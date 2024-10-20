class Solution {
    public double minimumAverage(int[] nums) {
        int left=0;
        int right=nums.length-1;
        double avg=Double.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++){
            
                double sum=(nums[left]+nums[right])/2.0;
               //  avg=sum/2;
                avg =Math.min(sum,avg);
                right--;
                left++;  
        }
        return avg;
    }
}