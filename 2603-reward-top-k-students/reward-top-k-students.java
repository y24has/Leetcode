class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos=new HashSet<>();
        Set<String> neg=new HashSet<>();

        for(String word:positive_feedback){
            pos.add(word);
        }
        for(String word:negative_feedback){
            neg.add(word);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return Integer.compare(b[0], a[0]); // higher score first
        return Integer.compare(a[1], b[1]);
        });

        for(int i=0;i<report.length;i++){
            String[] words=report[i].split(" ");
            int score=0;
            for(int j=0;j<words.length;j++){
             if(pos.contains(words[j])){
                score+=3;
             }else if(neg.contains(words[j])){
                score-=1;
             }
            }
        pq.offer(new int[]{score,student_id[i]});
        }
        List<Integer> ans=new ArrayList<>();
        while(k>0){
            int[] top=pq.poll();
            int id=top[1];
            ans.add(id);
            k--;
        }
        return ans;
    }
}