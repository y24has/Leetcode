class Solution{
    public int subarraysDivByK(int[] nums, int k){
        int count = 0;           
        int n = nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<n;i++){
        sum+=nums[i];
        int lookup=((sum % k) + k) % k;
        if(map.containsKey(lookup)){
            count+=map.get(lookup);
        }
        map.put(lookup,map.getOrDefault(lookup,0)+1);
        }
        return count;
    }
}