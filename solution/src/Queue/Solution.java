package Queue;

import java.util.Stack;

/**
 * Created by Xiaojun YU on 2017-03-19.
 */
public class Solution {
    public static class MyQueue<T> {
        private Stack<T> stackOldestOnTop = new Stack<>();
        private Stack<T> stackNewestOnTop = new Stack<>();

        public void enqueue(T value) {
            // add item
            stackNewestOnTop.push(value);
        }

        public T peek() {
            // Get "oldest" item
            // move elements from stackNewest to stackOldest
            shiftStack();
            return stackOldestOnTop.peek();
        }

        private void shiftStack() {
            if (stackOldestOnTop.isEmpty()){
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }

        public T dequeue() {
            shiftStack();
            return stackOldestOnTop.pop();
        }
    }
}
