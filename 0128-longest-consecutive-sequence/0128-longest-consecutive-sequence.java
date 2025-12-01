class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest=0;
        int count=0;
        for(int num:set){
           if(!set.contains(num-1)){
            count=1;
            int curr=num;
            while(set.contains(curr+1)){
                curr+=1;
                count++;
            }
            longest=Math.max(longest,count);
           }
        }
        return longest;
    }
}