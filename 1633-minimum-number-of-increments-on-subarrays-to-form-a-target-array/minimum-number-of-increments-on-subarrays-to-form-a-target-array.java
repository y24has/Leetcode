class Solution {
    public int minNumberOperations(int[] target) {
      int prev = target[0];
      int steps = target[0];

for (int i = 1; i < target.length; i++) {
    if (target[i] > prev) {
        steps += (target[i] - prev); 
    }
    prev = target[i];
}  
return steps;
    }
}