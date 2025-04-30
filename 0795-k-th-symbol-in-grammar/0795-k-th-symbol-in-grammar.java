class Solution {
    public int kthGrammar(int n, int k) {
     if(n==1 && k==1){  //1 based index so n=1 k=0   
        return 0;
     }   
       int mid = (int)Math.pow(2,n-1)/2;                   //  Row 1: 0
       if(k<=mid){                                         //  Row 2: 0
        return kthGrammar(n-1,k);                             //  Row 3: 0110
       }
       else{
        return 1- kthGrammar(n-1,k-mid);
       }
    
    }
}

// for zero based index 
// class Solution {
//     public int kthGrammar(int n, int k) {     
//      if(n==0){
//         return 0;
//      }   
//        int mid = (int)Math.pow(2,n-1);
//        if(k<=mid){
//         return kthGrammar(n-1,k);
//        }
//        else{
//         return 1-kthGrammar(n-1,k);
//        }
    
//     }
// } 