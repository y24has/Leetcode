class Solution {
    public int singleNonDuplicate(int[] nums) {
      int low=0;
      int high=nums.length-1;
      int N=high+1;
      if(nums.length==0)return -1;
      if(nums.length==1)return nums[nums.length-1];
      while(low<=high){
        int mid=low+(high-low)/2;
        int prev=(mid+N-1) % N;
        int next=(mid+1) % N; 
        if(nums[mid]!=nums[prev] && nums[mid]!=nums[next]){
            return nums[mid];
        }
        /*
            The array follows a pattern:
            - Every pair of elements appears twice, in consecutive indices.
            - Before the unique element, pairs appear as (even, odd).
            - After the unique element, the pattern misaligns: (odd, even).
            
            Condition Check:
            - If mid is odd and nums[mid] == nums[prev], we are still in the left half.
            - If mid is even and nums[mid] == nums[next], we are still in the left half.
            - In both cases, move right (low = mid + 1).
            
            Otherwise, move left (high = mid - 1).
            */
        else if(mid%2==1 && nums[mid]==nums[prev]  || mid%2==0 && nums[mid]==nums[next]) 
        {
            low=mid+1;
        }
        else {
            high=mid-1;
        }
      }
      return -1;  
    }
}