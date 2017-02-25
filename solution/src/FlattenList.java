import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Xiaojun YU on 2017-02-24.
 */
public class FlattenList {
    public class Vector2D implements Iterator<Integer> {
        private ArrayList<Integer> res = new ArrayList<>();
        private int i = 0;
        private int size;
        public Vector2D(List<List<Integer>> vec2d) {
            if (!(vec2d == null || vec2d.size() == 0)){
                for (List<Integer> list : vec2d){
                    for (int item : list){
                        if (!res.contains(item)) res.add(item);
                    }
                }
                Arrays.sort(res.toArray());
                this.size = res.size();
            }
        }

        @Override
        public Integer next() {
            int result = res.get(i);
            i++;
            return result;
        }

        @Override
        public boolean hasNext() {
            return i<size;
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
