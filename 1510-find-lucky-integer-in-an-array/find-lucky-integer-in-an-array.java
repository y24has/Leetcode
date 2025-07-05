class Solution {
    public int findLucky(int[] arr) {
    Map<Integer,Integer> map=new HashMap<>();

    for(Integer num:arr){
        map.put(num,map.getOrDefault(num,0)+1);
    }
    int result=-1;
    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        int key=entry.getKey();
        int value=entry.getValue();
        if(key==value)
        {
            result=Math.max(result,value);
        }
     }
     return result;
    }
}