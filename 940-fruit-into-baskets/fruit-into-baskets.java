class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int right=0;
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(right=0;right<fruits.length;right++){
            int num=fruits[right];
            map.put(num,map.getOrDefault(num,0)+1);

            while(map.size()>2){
                int left_num=fruits[left];
                map.put(left_num,map.getOrDefault(left_num,0)-1);
                if(map.get(left_num)==0) {
                    map.remove(left_num);
                }
                left++;
            }
           
            count=Math.max(count,(right-left+1));
      }
      return count;
    }
}