import java.util.Arrays;

/**
 * Created by Xiaojun YU on 2017-02-27.
 */

class Container {
    public double first;
    public double second;
    public Container(double first, double second)
    {
        this.first = first;
        this.second = second;
    }
}
public class OptimalWeights {

    public static Container findOptimalWeights(double capacity, double[] weights)
    {
        if(weights == null || weights.length < 2) return null;
        Arrays.sort(weights);
        if (weights[0] + weights[1] > capacity) return null;
        double i = weights[0], j = weights[1];
        int l = 0, r = weights.length - 1;
        while (l < r)
        {
            if (weights[l] + weights[r] == capacity) return new Container(weights[l], weights[r]);
            else if (weights[l] + weights[r] > capacity) r--;
            else
            {
                if(weights[l] + weights[r] > i + j)
                {
                    i = weights[l];
                    j = weights[r];
                }
                l++;
            }
        }
        return new Container(i, j);
    }

    public static void main(String[] args)
    {
        Container res = findOptimalWeights(35, new double[]{10, 23, 44, 9, 19});
        System.out.println();
    }
}
