class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long subarrayCnt=0;
        long count=0;
        for(int i=0;i<nums.length;i++){
            while(i<nums.length && nums[i]==0){
                count++;
                subarrayCnt+=count;
                i++;
            }
            count=0;
        }
        return subarrayCnt;
    }
}