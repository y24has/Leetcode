class Solution {
    public int partitionString(String s) {
         Map<Character, Integer> map = new HashMap<>();
        int count = 1;

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                count++;
                map.clear();
            }
            map.put(c, 1);
        }
        return count;
    }
}