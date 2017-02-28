/**
 * Created by Xiaojun YU on 2017-02-26.
 */
public class OverlapRectangle {
    class Node
    {
        int x;
        int y;
        public Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public class Solution {
        // A & C is bottom-let, B & D is top-right
        public boolean hasOverlap(Node A, Node B, Node C, Node D) {
            int bottomleft1_x = Math.min(A.x, B.x);
            int bottomleft1_y = Math.max(A.y, B.y);
            int topright1_x = Math.max(A.x, B.x);
            int topright1_y = Math.max(A.y, B.y);

            int bottomleft2_x = Math.min(C.x, D.x);
            int bottomleft2_y = Math.min(C.y, D.y);
            int topright2_x = Math.max(C.x, D.x);
            int topright2_y = Math.max(C.y, D.y);

            if(bottomleft1_x >= topright2_x || bottomleft2_x >= topright1_x
                    || bottomleft1_y >= topright2_y || bottomleft2_y >= topright1_y) {
                return false;
            }
            return true;
        }
    }
}
