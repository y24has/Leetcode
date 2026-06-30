class Solution {
    public int numberOfSubstrings(String s) {
           Map<Character, Integer> countMap = new HashMap<>();
    Set<Character> charSet = new HashSet<>();
    int left = 0;
    int result = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char current = s.charAt(right);
        countMap.put(current, countMap.getOrDefault(current, 0) + 1);
        charSet.add(current);
        
        while (charSet.size() == 3) {
            result += s.length() - right;
            char leftChar = s.charAt(left);
            countMap.put(leftChar, countMap.get(leftChar) - 1);
            if (countMap.get(leftChar) == 0) {
                charSet.remove(leftChar);
            }
            left++;
        }
    }
    
    return result; 
    }
}