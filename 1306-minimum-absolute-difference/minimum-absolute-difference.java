class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            min=Math.min(min,arr[i+1]-arr[i]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        //  List<Integer> res=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            List<Integer> res=new ArrayList<>();
            if(arr[i+1]-arr[i]==min){
                res.add(arr[i]);
                res.add(arr[i+1]);
                ans.add(res);
            }
               
        }
    
        return ans;
    }
}