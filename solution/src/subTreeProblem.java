/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class subTreeProblem {
    class Node
    {
        int data;
        Node left, right, nextRight;
        Node(int item)
        {
            data = item;
            left = right = nextRight = null;
        }
    }

    class BinaryTree
    {
        Node root1, root2;
        /* A utility funciton to check wether trees with roots as root 1 and root 2
        are identical or not
         */
        boolean areIdentical(Node root1, Node root2)
        {
            /* base cases*/
            if (root1 == null && root2 == null) return true;
            if (root1 == null || root2 == null) return false;
            /* Check if the data of both roots is same and data of left and right subtrees are also same */
            return (root1.data == root2.data
                    && areIdentical(root1.left, root2.left)
                    && areIdentical(root1.right, root2.right));
        }
        /*
        This function returns true if S is a subtree of T, otherwise false
         */
        boolean isSubtree(Node T, Node S)
        {
            /* base cases *.

             */
            if (S == null) return true;
            if (T == null) return false;

            /* Check the tree with root as current node */
            if (areIdentical(T, S)) return true;
            /* If the tree with root as current node doesn't match then
            try left and right subtrees one by one
             */
            return isSubtree(T.left, S) || isSubtree(T.right, S);
        }
    }
}
