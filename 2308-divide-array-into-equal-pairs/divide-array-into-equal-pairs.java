class Solution {
    public boolean divideArray(int[] nums) {
          Map<Integer, Integer> map = new HashMap<>();

       
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        for (int key : map.keySet()) {
            int val = map.get(key);
            while (val >= 2) {
                val -= 2;
            }

            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}