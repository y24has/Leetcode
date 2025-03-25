class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low=0;
        int high=letters.length-1;
        char Greater_letter=letters[0];
        if(high+1==0)return Greater_letter;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(letters[mid]>target){
               Greater_letter=letters[mid];
               high=mid-1;
            }
            else if(letters[mid]<=target){
                low=mid+1;
            }
        }
        return Greater_letter;
    }
}