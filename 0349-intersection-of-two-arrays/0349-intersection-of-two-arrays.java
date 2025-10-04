class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
          if(map.getOrDefault(num,0)>0){
            ans.add(num);
            map.remove(num);
          }
        }
        int[] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
           result[i]=ans.get(i);
        }
        return result;
    }
}