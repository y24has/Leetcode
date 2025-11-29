class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int MaxLen=0;
        int bal=0;
        map.put(0,-1);

        for(int i=0;i<nums.length;i++){
            bal+=nums[i]==1?1:-1;
            if(map.containsKey(bal)){
            MaxLen=Math.max(MaxLen,i-map.get(bal));
            }else{
            map.put(bal,i);
        }
        }
        return MaxLen;
    }
}