class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int alice_cap=capacityA;
        int Bob_cap=capacityB;
        int low=0;
        int result=0;
        int high=plants.length-1;
        while(low<high){
            if(plants[low]>alice_cap){
                alice_cap=capacityA;
                result++;
            }
            if(plants[high]>Bob_cap){
                Bob_cap=capacityB;
                result++;
            }
            alice_cap-=plants[low];
            Bob_cap-=plants[high];
            low++;
            high--;
        }

        if(plants.length%2!=0 && low==high){
            if(alice_cap>Bob_cap||alice_cap==Bob_cap){
                if(plants[low]>alice_cap){
                alice_cap=capacityA;
                result++;
            }
             alice_cap-=plants[low];
            }else if(alice_cap<Bob_cap){
                 if(plants[high]>Bob_cap){
                Bob_cap=capacityB;
                result++;
            }
                Bob_cap-=plants[high];
            }
            low++;
            high--;
        }
      return result;
    }
}