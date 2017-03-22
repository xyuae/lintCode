package miniTweet;

import java.util.*;

/**
 * Created by Xiaojun YU on 2017-03-07.
 */

public class MiniTwitter {
    static class Tweet {
        public int id;
        public int user_id;
        public String text;
        public Tweet(int user_id, String tweet) {
            this.user_id = user_id;
            this.text = tweet;
        }
        public static Tweet create(int user_id, String tweet_text) {
            return new Tweet(user_id, tweet_text);
        }
    }
    class Node {
        public int order;
        public Tweet tweet;
        public Node(int o, Tweet t) {
            this.order = o;
            this.tweet = t;
        }
    }

    class SortByOrder implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Node node1 = (Node) o1;
            Node node2 = (Node) o2;
            if (node1.order < node2.order) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    private Map<Integer, Set<Integer>> friends;
    private Map<Integer, List<Node>> users_tweets;
    private int order;

    public List<Node> getLastTen(List<Node> tmp) {
        int last = 10;
        if (tmp.size() < 10) {
            last = tmp.size();
        }
        return tmp.subList(tmp.size() - last, tmp.size());
    }

    public MiniTwitter() {
        this.friends = new HashMap<>();
        this.users_tweets = new HashMap<>();
        this.order = 0;
    }

    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet = Tweet.create(user_id, tweet_text);
        if (!users_tweets.containsKey(user_id)) {
            users_tweets.put(user_id, new ArrayList<Node>());
        }
        order += 1;
        users_tweets.get(user_id).add(new Node(order, tweet));
        return tweet;
    }

    public List<Tweet> getNewsFeed(int user_id) {
        List<Node> tmp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        if (friends.containsKey(user_id)) {
            for (Integer user : friends.get(user_id)) {
                if (users_tweets.containsKey(user)) {
                    tmp.addAll(getLastTen(users_tweets.get(user)));
                }
            }
        }
        
        tmp.sort(new SortByOrder());
        List<Tweet> rt = new ArrayList<Tweet>();
        tmp = getFirstTen(tmp);
        for (Node node : tmp) {
            rt.add(node.tweet);
        }
        return rt;
    }

    public List<Tweet> getTimeline(int user_id) {
        List<Node> tmp = new ArrayList<>();
        if (users_tweets.containsKey(user_id)) {
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        }
        tmp.sort(new SortByOrder());
        List<Tweet> rt = new ArrayList<>();
        tmp = getFirstTen(tmp);
        for (Node node : tmp) {
            rt.add(node.tweet);
        }
        return rt;
    }

    private List<Node> getFirstTen(List<Node> tmp) {
        int last = 10;
        if (tmp.size() < 10) {
            last = tmp.size();
        }
        return tmp.subList(0, last);
    }

    public void follow(int from_user_id, int to_user_id) {
        if (!friends.containsKey(from_user_id)){
            friends.put(from_user_id, new HashSet<Integer>());
        }
        friends.get(from_user_id).add(to_user_id);
    }

    public void unfollow(int from_user_id, int to_user_id) {
        if (friends.containsKey(from_user_id)) {
            friends.get(from_user_id).remove(to_user_id);
        }
    }
}
