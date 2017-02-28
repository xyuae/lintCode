import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Xiaojun YU on 2017-02-27.
 */
public class KCloesestPoints {
    class Point
    {
        double x;
        double y;
        public Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
    }

    private static double distance(Point a, Point b)
    {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static Point[] closestPoint(Point[] array, final Point origin, int k)
    {
        if(k > array.length) return array;
        Point[] res = new Point[k];
        Arrays.sort(array, new Comparator<Point>(){
            @Override
            public int compare(Point a, Point b) {
                return Double.compare(distance(a, origin), distance(b, origin));
            }
        });
        for(int i = 0; i < k; i++){
            res[i] = array[i];
        }
        return res;
    }

    public static Point[] closestPoint2(Point[] array, final Point origin, int k)
    {
        if (k > array.length) return array;
        Point[] res = new Point[k];
        PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>()
        {
            @Override
            public int compare(Point a, Point b)
            {
                return -Double.compare(distance(a, origin), distance(b, origin  ));
            }
        });
        for(Point p : array) queue.offer(p);
        while(queue.size() > k) queue.poll();
        for(int i = 0; i < k; i++) res[k - 1 - i] = queue.poll();
        return res;
    }
}
