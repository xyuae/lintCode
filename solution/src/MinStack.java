import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaojun YU on 2017-02-21.
 */
public class MinStack {
    private int size = 0;
    private List<Integer> array = new ArrayList<>();
    public MinStack() {
    }

    public void push(int number) {
        // write your code here
        array.add(number);
        size++;
        bubbleUp();
    }

    public int pop() {
        // write your code here
        int result = min();
        swap(0, size - 1);

        array.remove(size - 1);
        size--;
        bubbleDown();
        return result;
    }

    public int min() {
        // write your code here
        return array.get(0);
    }

    private int parent(int child) {
        return (int) Math.floor(child/2);
    }

    private int left(int parent) {
        return parent * 2;
    }

    private int right(int parent) {
        return parent * 2 + 1;
    }

    private void swap(int first, int second) {
        int temp = array.get(second);
        array.set(second, array.get(first));
        array.set(first, temp);
    }

    private void bubbleUp() {
        int child = size - 1;
        int parent = parent(child);
        while (array.get(child) < array.get(parent)){
            swap(parent, child);
            child = parent;
            parent = parent(child);
        }
    }

    private void bubbleDown() {
        int parent = 0;
        int left = left(parent);
        int right = right(parent);
        int child;
        if (left >= size) return;
        if (right >= size) child = left;
        else {
            child = array.get(left) > array.get(right) ? right : left;
        }
        while (array.get(child) < array.get(parent)) {
            swap(parent, child);
            parent = child;
            left = left(parent);
            right = right(parent);
            if (left >= size) return;
            if (right >= size) child = left;
            else {
                child = array.get(left) > array.get(right) ? right : left;
            }
        }
    }
}
