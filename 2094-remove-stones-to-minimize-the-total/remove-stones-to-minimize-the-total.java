class Solution {
    public int minStoneSum(int[] piles, int k) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int pile : piles) {
            maxHeap.add(pile);
        }

        while (k > 0) {
            int pile = maxHeap.poll();
            int removed = pile / 2;             
            int newPile = pile - removed;    
            maxHeap.add(newPile);
            k--;
        }

        int sum = 0;
        while (!maxHeap.isEmpty()) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}