class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ans_F=0;
        int ans_T=0; 
        return Math.max(maxConfusion(answerKey,k,'F','T',ans_F),maxConfusion(answerKey,k,'T','F',ans_F));
    }

    static int maxConfusion(String answerKey,int k,char ltr,char Flip_ltr,int Max_len){
        int right=0;
        int left=0;
        Max_len=0;
        int char_cnt=0;
        for(right=0;right<answerKey.length();right++){
            char ch=answerKey.charAt(right);
            if(ch==Flip_ltr) char_cnt++;
            while(char_cnt>k){
               if(answerKey.charAt(left)==Flip_ltr) char_cnt--;
               left++;
            }
            Max_len=Math.max(Max_len,right-left+1);
        }
        return Max_len;
    }
}