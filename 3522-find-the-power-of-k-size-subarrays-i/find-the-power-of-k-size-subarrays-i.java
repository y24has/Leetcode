class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> window=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        
        
        int check_num=-1;
        boolean flag=true;

        for(int i=0;i<k;i++){
        window.add(nums[i]);
        }
       for(int j=1;j<window.size();j++){
            if(window.get(j)!=window.get(j-1)+1){
               flag=false;
               break;
                }
            }

        res.add(flag ? window.get(window.size() - 1) : -1);

        for(int i=k;i<nums.length;i++){
            window.remove(0);
            window.add(nums[i]);

            flag=true;
            for(int j=1;j<window.size();j++){
                if(window.get(j)!=window.get(j-1)+1){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
                res.add(window.get(window.size()-1));
            }else{
               res.add(-1);
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}