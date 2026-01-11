class Solution {
    public int centeredSubarrays(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> set=new HashSet<>();
            int sum=0;
            for(int j=i;j<nums.length;j++){
               set.add(nums[j]);
               sum+=nums[j];
               if(set.contains(sum)){
                count++;
               }
            }
        }
        return count;
    }
}