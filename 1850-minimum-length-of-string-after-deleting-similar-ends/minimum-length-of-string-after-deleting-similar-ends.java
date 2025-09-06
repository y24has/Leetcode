class Solution {
    public int minimumLength(String s) {
        int low=0,high=s.length()-1;

        while(low<high && s.charAt(low)==s.charAt(high)){
                char ch=s.charAt(low);
                while(low<=high && ch==s.charAt(low)){
                    low++;
                }
                while(high>=low && ch==s.charAt(high)){
                    high--;
                }
            }
        return high-low+1;
    }
}