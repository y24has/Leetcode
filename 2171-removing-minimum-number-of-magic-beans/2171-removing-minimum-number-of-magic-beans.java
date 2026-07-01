class Solution {
    public long minimumRemoval(int[] beans) {
         Arrays.sort(beans);

        int n = beans.length;

        long totalSum = 0;
        for (int bean : beans) {
            totalSum += bean;
        }

        long minRemove = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            // Beans that remain if every non-empty bag has beans[i] beans
            long keep = (long) beans[i] * (n - i);

            // Beans to remove
            long remove = totalSum - keep;

            minRemove = Math.min(minRemove, remove);
        }

        return minRemove;  
    }
}