class Solution {
    public int numDistinct(String s, String t) {
        // Edge case: if target is longer than source, it's impossible.
        if (t.length() > s.length()) {
            return 0;
        }
        
        // We use Integer object array so we can use 'null' for unvisited states.
        Integer[][] memo = new Integer[s.length()][t.length()];
        
        // Start the engine with both pointers at index 0
        return helper(0, 0, s, t, memo);
    }
    
    private int helper(int i, int j, String s, String t, Integer[][] memo) {
        // 1. Victory Bouncer (Your exact logic!)
        // Target pointer reached the end. We spelled the word!
        if (j == t.length()) {
            return 1;
        }
        
        // 2. Dead End Bouncer (Your exact logic!)
        // Source pointer reached the end, but target is still waiting for letters.
        if (i == s.length()) {
            return 0;
        }
        
        // 3. Cache Check
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        int total_ways = 0;
        
        // 4. The Match (Take or Skip!)
        if (s.charAt(i) == t.charAt(j)) {
            // Universe A: We TAKE the letter (Both pointers move)
            int take = helper(i + 1, j + 1, s, t, memo);
            
            // Universe B: We SKIP the letter (Only source pointer moves)
            int skip = helper(i + 1, j, s, t, memo);
            
            // We want the total count, so we add them together
            total_ways = take + skip;
        } 
        // 5. The Mismatch (Forced Skip)
        else {
            // The letters don't match. We have absolutely no choice but to 
            // skip the current letter in 's' and look for a match later.
            total_ways = helper(i + 1, j, s, t, memo);
        }
        
        // 6. Save and Return
        memo[i][j] = total_ways;
        return total_ways;
    }
}