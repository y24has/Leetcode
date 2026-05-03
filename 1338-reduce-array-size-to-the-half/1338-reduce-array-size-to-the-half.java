class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        pq.addAll(map.values());

        int removed = 0;
        int count = 0;
        int target = arr.length / 2;

        while (removed < target) {
            removed += pq.poll(); 
            count++;           
        }

        return count;
    }
}