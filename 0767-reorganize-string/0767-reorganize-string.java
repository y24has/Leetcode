class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

  
        PriorityQueue<Character> pq =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {

            char curr = pq.poll();

            
            if (result.length() > 0 &&
                result.charAt(result.length() - 1) == curr) {

                if (pq.isEmpty()) return "";

                char next = pq.poll();

                result.append(next);
                map.put(next, map.get(next) - 1);

                if (map.get(next) > 0) pq.offer(next);

                pq.offer(curr);

            } else {
                
                result.append(curr);
                map.put(curr, map.get(curr) - 1);

                if (map.get(curr) > 0) pq.offer(curr);
            }
        }

        return result.toString();
    }
}