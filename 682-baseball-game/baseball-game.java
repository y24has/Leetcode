class Solution {
    public int calPoints(String[] ops) {
         Stack<Integer> s = new Stack<>();

        for (String op : ops) {
            if (op.equals("+")) {
                int last = s.pop();
                int prev = s.peek();
                s.push(last);
                s.push(last + prev);
            } 
            else if (op.equals("C")) {
                s.pop();
            } 
            else if (op.equals("D")) {
                s.push(2 * s.peek());
            } 
            else {
                s.push(Integer.parseInt(op));
            }
        }

        int total = 0;
        for (int score : s) total += score;
        return total;
    }
     private boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        int start = (s.charAt(0) == '-') ? 1 : 0;
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}