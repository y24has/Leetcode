class Solution {
    public String simplifyPath(String path) {
        String[] s=path.split("/");
        Stack<String> st=new Stack<>();

        for(int i=0;i<s.length;i++){
           if(s[i].equals("")|| s[i].equals(".")){
            continue;
           }else if(s[i].equals("..")){
            if(!st.isEmpty()) st.pop();
           }else{
            st.push(s[i]);
           }
        }
    StringBuilder sb=new StringBuilder();
    for(String dir:st){
        sb.append('/').append(dir);
    }
    return sb.length()==0?"/":sb.toString();
    }
}