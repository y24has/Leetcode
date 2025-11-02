class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       Arrays.sort(nums);
       int min=nums[0];
       int max=nums[nums.length-1];
       Set<Integer> set=new HashSet<>();
       List<Integer> ans=new ArrayList<>();
       for(int num:nums){
          set.add(num);
       }
       for(int i=min;i<max;i++){
           if(!set.contains(i)){
            ans.add(i);
           }
       }
       return ans;
    }
}