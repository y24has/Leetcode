class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeftTime = 0;
        int maxRightTime = 0;

        // Loop 1: Find max time for left-moving ants
        for (int pos : left) {
            maxLeftTime = Math.max(maxLeftTime, pos);
        }

        // Loop 2: Find max time for right-moving ants
        for (int pos : right) {
            maxRightTime = Math.max(maxRightTime, n - pos);
        }

        // Return the global max
        return Math.max(maxLeftTime, maxRightTime);
    }
}