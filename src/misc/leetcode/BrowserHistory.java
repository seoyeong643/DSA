package misc.leetcode;

import java.util.ArrayList;
import java.util.List;

/* Using Inbuilt clear method of ArrayList
Time complexity:
    O(n) for Visit {clearing forward history}
    O(1) for back and forward
Space complexity:
    O(n) for LinkedList
 */
public class BrowserHistory {
    List<String> history;
    int curr;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
    }

    public void visit(String url) {
        history.subList(curr+1,history.size()).clear();
        history.add(url);
        curr++;
    }

    public String back(int steps) {
        curr = Math.max(curr - steps,0);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(curr + steps,history.size()-1);
        return history.get(curr);
    }
}




class Node{
    String val;
    Node next, prev;
    public Node(String val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
/* Simple LinkedList implementation
Time complexity:
    O(1) for Visit
    O(n) for back and forward
Space complexity:
    O(n) for LinkedList
 */
class BrowserHistory1 {
    Node home;
    Node curr;

    public BrowserHistory1(String homepage) {
        home = new Node(homepage);
        curr = home;
    }

    public void visit(String url) {
        curr.next = null;
        Node t = new Node(url);
        curr.next = t;
        t.prev = curr;
        curr = t;
    }

    public String back(int steps) {
        while(curr.prev != null && steps-- > 0){
            curr = curr.prev;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while(curr.next != null && steps-- > 0){
            curr = curr.next;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */