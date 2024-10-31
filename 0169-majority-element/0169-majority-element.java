class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int majorityCount=n/2;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            if(entry.getValue() > majorityCount){
                return entry.getKey();
            }
        }
            return -1;
    }
}