class Solution {
    public int maxIceCream(int[] costs, int coins) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all costs
        for (int cost : costs) {
            pq.add(cost);
        }

        int count = 0;

        // buy while affordable
        while (!pq.isEmpty() && coins >= pq.peek()) {
            coins -= pq.poll(); // spend coins
            count++;            // bought one
        }

        return count;
    }
}