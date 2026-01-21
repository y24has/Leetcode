class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int key=map.get(nums[i]);
                if(Math.abs(i-key)<=k) { 
                    flag=true;
                }
            }
              map.put(nums[i], i);
        }
        return flag;
    }
}