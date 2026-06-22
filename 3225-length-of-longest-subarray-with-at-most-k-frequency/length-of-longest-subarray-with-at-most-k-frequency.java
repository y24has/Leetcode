class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        int maxLength=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            int num=nums[right];

            map.put(num,map.getOrDefault(num,0)+1);
            int freq=map.get(num);

            while(freq>k){
                int toRem=nums[left];
                map.put(toRem,map.getOrDefault(toRem,0)-1);
                if(map.get(toRem)==0) map.remove(toRem);
                freq=map.getOrDefault(num,0);
                left++;
            }

            maxLength=Math.max(right-left+1,maxLength);
        }
        return maxLength;
    }
}