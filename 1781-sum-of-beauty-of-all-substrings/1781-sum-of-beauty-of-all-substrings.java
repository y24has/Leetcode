class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();
        
        // i is our starting finger
        for (int i = 0; i < n; i++) {
            
            // Using a HashMap to handle ANY character (Unicode, numbers, symbols)
            java.util.Map<Character, Integer> freq = new java.util.HashMap<>();
            
            // j is our highlighter stretching to the right
            for (int j = i; j < n; j++) {
                
                // Add or update the current letter in our hash map
                char c = s.charAt(j);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                
                // Now, find the max and min frequencies currently in the map
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                
                for (int count : freq.values()) {
                    maxFreq = Math.max(maxFreq, count);
                    minFreq = Math.min(minFreq, count);
                }
                
                // Calculate the beauty of this specific substring and add to total
                totalBeauty += (maxFreq - minFreq);
            }
        }
        
        return totalBeauty;
    }
}