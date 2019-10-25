package dataStruture.stack;

import java.util.LinkedList;

/**
 * @Description
 * @Author dianXiao2
 * 设计一个有getMin功能的stack
 *  要求
 *      1.pop, push, getMin操作的时间复杂度都是O(1)
 *      2. 设计的栈类型可以使用现成的栈结构
 * @Version V1.0.0
 * @Date 2019/10/25
 */
public class GetMinStack {

    public static void main(String[] args) {
        GetMinStack  stack = new GetMinStack();
        stack.push(19);
        stack.push(12);
        stack.push(4);
        stack.push(9);
        stack.push(112);
        stack.push(9);
        stack.push(1);
        stack.push(4);
        stack.push(8);
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    public GetMinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(Integer value) {
        if(minStack.isEmpty()){
            minStack.push(value);
        }else{
            Integer peek = minStack.peek();
            if(value <= peek){
                minStack.push(value);
            }
        }

        stack.push(value);
    }

    public Integer pop() {
        if(stack.isEmpty()){
            return null;
        }
        //从栈顶弹出元素
        Integer pop = stack.pop();

        if(pop > minStack.peek()){
            //不做任何处理
        }else {
            //弹出栈顶元素
            minStack.pop();
        }

        return pop;
    }


    public Integer getMin() {
        return minStack.peek();
    }
}

