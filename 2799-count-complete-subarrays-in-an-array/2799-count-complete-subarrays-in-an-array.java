class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> k_set=new HashSet<>();
        for(int num:nums){
           k_set.add(num);
        }
        if (k_set.size()==0)return 0;
    int res=0;
    int k=k_set.size();
    int left=0;
    Map<Integer,Integer> map=new HashMap<>();
    for(int right=0;right<nums.length;right++){
    map.put(nums[right],map.getOrDefault(nums[right],0)+1);

    while(map.size()==k){
    res=res+(nums.length-right);
    map.put(nums[left],map.get(nums[left])-1);
    if(map.get(nums[left])==0) {
    map.remove(nums[left]);
    }left++;
    }

    }
    return res;
    }
}