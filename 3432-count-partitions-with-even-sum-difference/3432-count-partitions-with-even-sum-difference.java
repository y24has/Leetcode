class Solution {
    public int countPartitions(int[] nums) {
        int[] prefix=new int[nums.length];
        int[] suffix=new int[prefix.length];
        prefix[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        suffix[nums.length-1]=nums[nums.length-1];
        for(int j=nums.length-2;j>=0;j--){
           suffix[j]=suffix[j+1]+nums[j];
        }
        int p_sum=0;
        int s_sum=0;
        int cnt=0;
        int chk_even=0;
        for(int p=0;p<nums.length-1;p++){
            p_sum=prefix[p]%2;
            if(p<nums.length-1) {s_sum=suffix[p+1]%2;
            }else{
                s_sum=0;
            }
            chk_even=Math.abs(p_sum+s_sum);
            if(chk_even%2==0){
             cnt++;
            }
        }
        return cnt;
    }
}