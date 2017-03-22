package SortWithComparator;

import java.util.Comparator;

/**
 * Created by Xiaojun YU on 2017-03-19.
 */
public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        return b.score - a.score;
    }
}
