class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<=0) return new int[0];
        int[] result=new int[nums.length-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<k;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        result[0]=map.lastKey();
        for(int i=k;i<nums.length;i++){
         map.put(nums[i-k],map.get(nums[i-k])-1);
         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                if(map.get(nums[i-k])==0){
                    map.remove(nums[i-k]);
                }
         result[i-k+1]=map.lastKey();
        }
       return result;
    }
}