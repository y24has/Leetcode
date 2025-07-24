class Solution {
    public void duplicateZeros(int[] arr) {
        
        int[] res_arr=new int[arr.length];
        int index=0;
        for(int i=0;i<arr.length && index<arr.length;i++){
            if(arr[i]==0){
             index+=2;
            }else{
                res_arr[index]=arr[i];
                index++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=res_arr[i];
        }
    }
}