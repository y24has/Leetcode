class Solution {
    public int countCollisions(String directions) {
//     int n = s.length();
//     int left = 0, right = n - 1;

//     // 1. skip leading L
//     while (left < n && s.charAt(left) == 'L') left++;

//     // 2. skip trailing R
//     while (right >= 0 && s.charAt(right) == 'R') right--;

//     // 3. no collisions possible
//   Stack<Character> st = new Stack<>();
//     int collisions = 0;

//     // 4. push the first active cow
//     st.push(s.charAt(left));

//     // 5. iterate over the middle
//     for (int i = left + 1; i <= right; i++) {
//         char curr = s.charAt(i);

//         char top = st.peek();

//         if (top == curr) {
//             // same direction → no collision
//             st.push(curr);
//         } 
//         else {
//             // collision zone
//             if (curr == 'S') {
//                 collisions += 1;
//                 break;
//             } else {
//                 // curr == R or L opposite to top
//                 collisions += 2;
//                 break;
//             }
//           //  st.clear();
//            // st.push(curr);
//         }
//     }
//     int add=n-left;
//     return collisions+add;
int left = 0;
        int right = directions.length() - 1;
        
        // 1. Skip safe cars driving away to the Left
        while (left <= right && directions.charAt(left) == 'L') {
            left++;
        }
        
        // 2. Skip safe cars driving away to the Right
        while (left <= right && directions.charAt(right) == 'R') {
            right--;
        }
        
        // 3. Count all doomed moving cars in the middle
        int collisions = 0;
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') { // If it's L or R, it crashes
                collisions++;
            }
        }
        
        return collisions;
    }
}