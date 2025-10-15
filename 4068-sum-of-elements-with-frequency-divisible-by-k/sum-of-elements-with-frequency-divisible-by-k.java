class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> check:map.entrySet()){
         int key=check.getKey();
         int freq=check.getValue();
         if(freq%k==0){
            sum=sum+key*freq;
          }
        }
        return sum;
    }
}