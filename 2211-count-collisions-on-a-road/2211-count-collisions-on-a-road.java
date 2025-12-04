class Solution {
    public int countCollisions(String s) {
    int n = s.length();
    int left = 0, right = n - 1;

    // 1. skip leading L
    while (left < n && s.charAt(left) == 'L') left++;

    // 2. skip trailing R
    while (right >= 0 && s.charAt(right) == 'R') right--;

    // 3. no collisions possible
    if (left > right) return 0;
    int collisions = 0;
    for (int i = left; i <= right; i++) {
        char curr = s.charAt(i);
        if(curr!='S') collisions++;
    }
    return collisions;
    }
}