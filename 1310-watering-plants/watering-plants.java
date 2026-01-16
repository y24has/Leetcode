class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps=0;
        int cap=capacity;
        for(int i=0;i<plants.length;i++){
            cap-=plants[i];
            steps++;
            if(i<plants.length-1 &&cap<plants[i+1]){
               steps+=(i+1)*2;
               cap=capacity;
            }
        }
        return steps;
    }
}