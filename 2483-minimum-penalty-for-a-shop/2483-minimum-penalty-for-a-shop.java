class Solution {
    public int bestClosingTime(String customers) {
   int n = customers.length();
        
        // 1. Initialize two arrays of size N + 1
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];
        
        // 2. Left to right (Prefix Array)
        prefix[0] = 0; // At hour 0, the past penalty is 0
        for (int i = 1; i <= n; i++) {
            if (customers.charAt(i - 1) == 'N') {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }
        
        // 3. Right to left (Suffix Array)
        suffix[n] = 0; // At hour n, the future penalty is 0
        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                suffix[i] = suffix[i + 1] + 1;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        
        // 4. Find the minimum total penalty
        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;
        
        for (int i = 0; i <= n; i++) {
            int currentPenalty = prefix[i] + suffix[i];
            
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                bestHour = i; // i is naturally ascending, so it keeps the earliest hour
            }
        }
        
        return bestHour;
    }
}