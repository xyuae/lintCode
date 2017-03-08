package uber;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Xiaojun YU on 2017-03-06.
 */
class TreeNode {
    public int time;
    public TreeNode left, right;

    public TreeNode (int time) {
        this.time = time;
        this.left = null;
        this.right = null;
    }
}

class Bst {
    private HashMap<Integer, String> map;
    private TreeNode head;
    public Bst () {
        map = new HashMap<>();
    }
    public void addPoint(int time, String location) {
        if (!map.containsValue(location)) {
            map.put(time, location);
            // add the key into bst
            if (head == null) {
                head = new TreeNode(time);
            } else {
                // find the location and add
                TreeNode temp = head;
                boolean isLeft = false;
                TreeNode parent = null;
                while (temp != null) {
                    if (time < temp.time) {
                        parent = temp;
                        temp = temp.left;
                        isLeft = true;
                    } else if (time > temp.time) {
                        parent = temp;
                        temp = temp.right;
                        isLeft = false;
                    } else {
                        System.out.println("The implementation of add has an error, time should not be eqaul to temp.time");
                    }
                }
                // end of while, the temp is the place we want to add
                if (isLeft) {
                    parent.left = new TreeNode(time);
                } else {
                    parent.right = new TreeNode(time);
                }
            }
        }
    }

    public String find(int key) {
        boolean isLeft = false;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        TreeNode temp = head;
        TreeNode parent = null;
        while (temp != null) {
            if (key < temp.time) {
                parent = temp;
                temp = parent.left;
                isLeft = true;
            }
            else if (key > temp.time) {
                parent = temp;
                temp = parent.right;
                isLeft = false;
            } else {
                System.out.println("The implementation of find has an error, key should not equal to temp.time");
            }
        }
        if (!isLeft) {
            return map.get(parent.time);
        } else {
            return map.get(getParent(parent.time));
        }
    }

    private int getParent(int key) {
        TreeNode temp = head;
        TreeNode parent = null;
        while (temp != null) {
            if (key < temp.time) {
                parent = temp;
                temp = parent.left;
                //isLeft = true;
            }
            else if (key > temp.time) {
                parent = temp;
                temp = parent.right;
                //isLeft = false;
            } else {
                // return the parent
                if (parent == null) {
                    return -1;
                }
                return parent.time;
                //System.out.println("The implementation of find has an error, key should not equal to temp.time");
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Bst s = new Bst();
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
