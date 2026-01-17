class Solution {
    public int maximum69Number (int num) {
           String original = String.valueOf(num);
        int max = num;

        for (int i = 0; i < original.length(); i++) {

            char ch = original.charAt(i);
            if (ch == '6') {
                StringBuilder sb = new StringBuilder(original);
                sb.setCharAt(i, '9');
                int val = Integer.parseInt(sb.toString());
                max = Math.max(max, val);
            }
        }
        return max;
    }
}