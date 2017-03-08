package uber;

// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.


// 25, "location3"
// 15, "location1"
// 20, "location2"

// 20 => "location2"
// 24 => "location2"
// 100 => "location3"

class Node {
    public int time;
    public String location;
    public Node left, right, parent = null; // parent Node keep a refernce of parent node
    public Node (int time, String locaiton) {
        this.time = time;
        this.location = location;
    }
}

class Solution {
    private Node head;
    private boolean find; // whether the find() find the node;
    private boolean leftBool; // if the added Node is the left child
    public Solution() {
        head = null;
    }

    public Node find(int time) {
        // if the tree is empty
        find = true;
        if (head == null) {
            return head;
        }
        boolean smaller = false; // if my parent.time is smaller than time
        Node temp = head;
        while (temp != null) {
            if (time > temp.time) {
                // go to the right child
                temp = temp.right;
                smaller = true;
            } else if (time < temp.time) {
                // go to the left child
                temp = temp.left;
                smaller = false;
            } else {
                // when we find it
                return temp;
            }
        }
        find = false;
        if (smaller) {
            leftBool = false;
        }
        else {
            leftBool = true;
        }

        // when don't find it, we return
        // can return the most recent Node when the find is false;
        return temp.parent;
    }
    public int add(int time, String location) {
        // when the BST is empty
        if (head == null) {
            head = new Node(time, location);
        }
        Node temp = find(time);
        if (find == true) {
            return 1;
        } else {
            Node addNode = new Node(time, location);
            // temp is the parent node of my addNode;
            // if the addNode should be the left child
            if (leftBool) {
                temp.left = addNode;
                addNode.parent = temp;
            }
            else {
                temp.right = addNode;
                addNode.parent = temp;
            }
        }


        // when
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.add(24, "street");
        Node temp = s.find(24);
        // test add

        s.add(25, "street");
        Node temp1 = s.find(25);
        System.out.println(temp1.time);
    }
}