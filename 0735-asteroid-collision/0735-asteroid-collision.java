class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();

        for(int asteroid:asteroids){
            boolean flag=false;

            while(!stack.isEmpty() && asteroid<0 && stack.peek()>0){

                if(stack.peek()<-asteroid){
                    stack.pop();
                }
                else if(stack.peek()==-asteroid){
                    stack.pop();
                    flag=true;
                    break;
                }else{
                    flag=true;
                    break;
                }
            }
            if(!flag){
                stack.push(asteroid);
            }
        }
        int[] result=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return result;
    }
}