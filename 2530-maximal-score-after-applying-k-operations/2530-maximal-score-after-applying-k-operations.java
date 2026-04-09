class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for (int num : nums) {
            maxHeap.offer(num);
        }

        long score = 0;

        while (k>0) {
            k--;
            int curr = maxHeap.poll();
            score += curr;
            int updated = (curr + 2) / 3;
            maxHeap.offer(updated);
        }

        return score;
    }
}