class Solution{
    public String minWindow(String s, String t){
        Map<Character,Integer> map=new HashMap<>();
        int matched=0;
        int[] ans=new int[3];
        int left=0;
        ans[0]=Integer.MAX_VALUE;
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int right=0;right<s.length();right++){
           char ch1=s.charAt(right);
                if(map.containsKey(ch1)){
                      map.put(ch1,map.get(ch1)-1);
                      if(map.get(ch1)==0){
                        matched++;
                      }
                }

           while(map.size()==matched){     
               if(right-left+1<ans[0]){
                 ans[0]=right-left+1;
                 ans[1]=left;
                 ans[2]=right;
               }

               if(map.containsKey(s.charAt(left))){
                  map.put(s.charAt(left),map.get(s.charAt(left))+1);
                if (map.get(s.charAt(left)) > 0) {
                        matched--;
                    }
               }
               left++;
           }
        }
         return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}