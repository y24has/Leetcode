class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxFreq=0;
        for(Integer num:map.values()){
            maxFreq=Math.max(num,maxFreq);
        }
        int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==maxFreq){
                count+=maxFreq;
            }
        }
        return count;
    }
}