class Solution {
    public int countOdds(int low, int high) {
        int zero_low=0;
        int zero_high=0;

        zero_low=(low-0)/2;
        zero_high=(high+1)/2;

        return zero_high-zero_low;
    }
}