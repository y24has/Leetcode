class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left=-1;
        int right=removable.length;
       
        int ans=0;
        while(left+1<right){
            int mid=left+(right-left)/2;
            if(check(s,p,removable,mid)){
                ans=mid;
                left=mid;
            }else{
                right=mid;
            }
        }
        if(check(s,p,removable,right)) return right;
        return ans;
    }
        static boolean check(String s, String p,int[] removable, int mid){
        boolean[] isRemoved = new boolean[s.length()];
        for (int i = 0; i < mid; i++) {
            isRemoved[removable[i]] = true;
        }
        int p1 = 0; 
        int p2 = 0;
        while (p1 < s.length() && p2 < p.length()) {
            if (isRemoved[p1]) {
                p1++;
                continue;
            }
            if (s.charAt(p1) == p.charAt(p2)) {
                p2++; 
            }
            p1++; 
        }
        return p2 == p.length();
    }
}