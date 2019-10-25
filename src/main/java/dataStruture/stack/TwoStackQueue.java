package dataStruture.stack;

import java.util.LinkedList;

/**
 * @Description
 * 由两个栈组成的队列
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/10/25
 */
public class TwoStackQueue {
    private LinkedList<Integer> pushStack;
    private LinkedList<Integer> popStack;

    public TwoStackQueue() {
        pushStack = new LinkedList<>();
        popStack = new LinkedList<>();
    }

    public void add(Integer value) {
        pushStack.push(value);
    }

    public Integer poll() {
        if(!pushStack.isEmpty() && popStack.isEmpty()){
            while (pushStack.peek() != null){
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }

    public Integer peek() {
        if (popStack.isEmpty() && !pushStack.isEmpty()) {
            while (pushStack.pop() != null) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }
}
