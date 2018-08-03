package algorithms;

import java.util.Stack;

public class BaseBallGame {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        for(int i =0; i < ops.length; i ++){
            if(ops[i].equals("C")){
                if(!stack.empty()){
                    int temp = stack.pop();
                    result -= temp;
                }
            }else if(ops[i].equals("+")){
                int temp, count, sum;
                temp = count = sum = 0;
                if(!stack.empty()){
                    temp = stack.pop();
                    sum = sum + temp;
                    sum = sum + stack.peek();
                    stack.push(temp);
                    stack.push(sum);
                    result += sum;
                }else{
                    stack.push(0);
                }
            }else if(ops[i].equals("D")){
                int temp = stack.peek();
                result += (temp+temp);
                stack.push(temp+temp);
            }else{
                int temp = Integer.parseInt(ops[i]);
                result += (temp);
                stack.push(temp);
            }
            
        }
        return result;
    }
    
    public static void main(String args[]) {
    		System.out.println(calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
    }
}

