package stack;

import java.util.Stack;

public class MinStack extends Stack<Integer> {
    Stack<Integer> minStack;


    public  MinStack(){
        minStack = new Stack<Integer>();
    }

    public void push(int ele){
        if(ele < min()){
            minStack.push(ele);
        }
        super.push(ele);
    }

    public Integer pop(){
        return super.pop();
    }

    public int min(){
        if (minStack.isEmpty()){
            return Integer.MAX_VALUE;
        } else
        return minStack.peek();
    }

    public static void main(String args[]){
        MinStack m = new MinStack();
        m.push(2);
        m.push(8);
        m.push(1);
        m.push(3);
        m.push(6);

        System.out.println("stak is:"+ m.toString());

        System.out.println(m.min());
        System.out.println("top:"+m.peek());
        System.out.println("stak is:"+ m.toString());

    }
}
