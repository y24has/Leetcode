class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int countOnes = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }
            // Shrink if there are more than k ones
            while (countOnes > k) {
                if (s.charAt(left) == '1') {
                    countOnes--;
                }
                left++;
            }
            // Remove unnecessary leading zeros
            while (countOnes == k && s.charAt(left) == '0') {
                left++;
            }
            // Update answer
            if (countOnes == k) {
                String current = s.substring(left, right + 1);

                if (ans.isEmpty()
                        || current.length() < ans.length()
                        || (current.length() == ans.length()
                            && current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }
        return ans;
    }
}