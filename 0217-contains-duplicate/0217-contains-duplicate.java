class Solution {
    public boolean containsDuplicate(int[] nums) {
       HashMap<Integer,Integer> map=new HashMap<>(); 
     
        for(Integer num:nums){
            if(map.containsKey(num)){
                return true;
                }
                map.put(num,1);
            }
       return false;
    }
}
