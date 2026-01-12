class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
           char[] ch=strs[i].toCharArray();
           Arrays.sort(ch);
           String str=new String(ch);
            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(strs[i]);
        }

        List<List<String>> ans=new ArrayList<>();

        for(List<String> grp:map.values()){
            ans.add(grp);
        }
        return ans;
    }
}