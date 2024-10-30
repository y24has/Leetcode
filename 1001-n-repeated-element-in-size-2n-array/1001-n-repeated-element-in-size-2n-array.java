class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(Integer num:nums){
            if(map.containsKey(num)){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            else {
                map.put(num,1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
             if(entry.getValue()==n){
                return entry.getKey();
             }
        }
        return -1;
    }
}