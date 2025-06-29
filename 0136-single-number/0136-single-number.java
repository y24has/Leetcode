class Solution {
    public int singleNumber(int[] nums) {
      HashMap<Integer,Integer> map=new HashMap<>();
      for(Integer num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
      }  
      int number=0;
      for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        int value=entry.getValue();
        if (value==1){
            number=entry.getKey();
        }
      }
      return number;
    }
}