class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int key : map.keySet()) {
            maxHeap.offer(new int[]{key, map.get(key)});
        }

        int n = barcodes.length;
        int[] result = new int[n];
        int idx = 0;

        while (!maxHeap.isEmpty()) {

            int[] curr = maxHeap.poll();
            int val = curr[0];
            int count = curr[1];

            if (idx > 0 && result[idx - 1] == val) {
                int[] next = maxHeap.poll();
                int nextVal = next[0];
                int nextCount = next[1];

                result[idx++] = nextVal;
                nextCount--;

                if (nextCount > 0) {
                    maxHeap.offer(new int[]{nextVal, nextCount});
                }
        
                maxHeap.offer(curr);

            } else {
                result[idx++] = val;
                count--;

                if (count > 0) {
                    maxHeap.offer(new int[]{val, count});
                }
            }
        }

        return result;
    }
}