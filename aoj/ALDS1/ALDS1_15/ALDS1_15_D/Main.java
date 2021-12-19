/*
 *  ALDS1_15_B: Fractional Knapsack Problem
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_15_B
 */

package ALDS1.ALDS1_15.ALDS1_15_D;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int[] alpha = new int[26];
        for (char c : S.toCharArray()) {
            alpha[c - 'a']++;
        }

        PriorityQueue<Node> que = new PriorityQueue<>();
        for(int i=0; i<26; i++){
            if(alpha[i]>0){
                que.add(new Node(i, alpha[i]));
            }
        }
        if (que.size() == 1) {
            System.out.println(que.peek().occ);
            return;
        }
        ArrayList<Node> chars = new ArrayList<>();
        while (que.size() > 1) {
            Node left = que.poll(), right = que.poll();
            que.add(new Node(left, right));
            if(left.isAlpha()){
                chars.add(left);
            }
            if(right.isAlpha()){
                chars.add(right);
            }
        }
        setLength(0, que.peek());
        long total = 0;
        for (Node x : chars) {
            total += x.getValue();
        }
        System.out.println(total);



    }

    static void setLength(int length, Node target) {
        if (target == null) {
            return;
        }
        target.length = length;
        setLength(length + 1, target.left);
        setLength(length + 1, target.right);
    }


}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;
    int occ;
    int length;

    public Node(int value, Node left, Node right, int occ, int length) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.occ = occ;
        this.length = length;
    }

    Node(int value, int occ){
        this.value = value;
        this.occ=occ;
    }

    Node(Node left, Node right){
        this(-1, left, right, left.occ + right.occ, 0);
    }

    boolean isAlpha() {
        return value >= 0;
    }

    public int getValue() {
        return occ * length;
    }

    @Override
    public int compareTo(Node that) {
        return this.occ - that.occ;
    }

}
