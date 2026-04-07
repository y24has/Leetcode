class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];

            if (type == 0) { // BUY

                while (!sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] s = sell.peek();

                    int matched = Math.min(amount, s[1]);
                    amount -= matched;
                    s[1] -= matched;

                    if (s[1] == 0) sell.poll();
                    if (amount == 0) break;
                }

                if (amount > 0) buy.offer(new int[]{price, amount});

            } else { // SELL

                while (!buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] b = buy.peek();

                    int matched = Math.min(amount, b[1]);
                    amount -= matched;
                    b[1] -= matched;

                    if (b[1] == 0) buy.poll();
                    if (amount == 0) break;
                }

                if (amount > 0) sell.offer(new int[]{price, amount});
            }
        }

        long total = 0;
        int MOD = 1_000_000_007;

        while (!buy.isEmpty()) {
            total = (total + buy.poll()[1]) % MOD;
        }

        while (!sell.isEmpty()) {
            total = (total + sell.poll()[1]) % MOD;
        }

        return (int) total;
    }
}