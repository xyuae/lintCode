package uber;

import java.util.HashMap;
import java.util.TreeSet;

class Solution2 {
    private HashMap<Integer, String> map;
    private TreeSet<Integer> tree;
    public Solution2() {
        map = new HashMap<>();
        tree = new TreeSet<>();
    }
    public void addPoint(int time, String location) {
        if (!map.containsValue(location)) {
            map.put(time, location);
            tree.add(time);
        }
    }

    public String find(int key) {
            if (map.containsKey(key)) {
                return map.get(key);
            }
            else {
                int floorKey = tree.floor(key);
                return map.get(floorKey);
            }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.addPoint(2, "street");

        // test add

        s.addPoint(8, "North street");
        s.addPoint(1, "South street");
        s.addPoint(3, "East street");
        String temp = s.find(24);
        String temp1 = s.find(4);
        System.out.println(temp + " " + temp1);
    }
}
