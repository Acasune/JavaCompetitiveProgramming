/*
 *  ALDS1_8_D: Treap
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/8/ALDS1_8_D
 */

package ALDS1.ALDS1_8.ALDS1_8_D;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Treap treap = new Treap(N);
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            if (type.equals("insert")) {
                if (treap.root == null) {
                    treap.root = new Node(sc.nextInt(),sc.nextInt());
                } else {
                    treap.root=treap.insert(treap.root, sc.nextInt(), sc.nextInt());
                }
            }
            else if (type.equals("find")){
                System.out.println(treap.find(sc.nextInt())?"yes":"no");
            }
            else if(type.equals("delete")){
                int target=sc.nextInt();
                if(target==treap.root.key)treap.root=treap.delete(treap.root,target);
                else treap.delete(treap.root,target);

            }
            else {
                StringBuilder sb = new StringBuilder();
                ArrayList<Integer> inList = new ArrayList<>();
                ArrayList<Integer> preList = new  ArrayList<>();
                get(treap.root, inList, preList);
                for (int x : inList) {
                    sb.append(" ").append(x);
                }
                sb.append("\n");
                for (int x : preList) {
                    sb.append(" ").append(x);
                }
                sb.append("\n");
                System.out.print(sb);
            }
        }

    }
    static void get(Node x, ArrayList<Integer> inList, ArrayList<Integer> preList) {
        preList.add(x.key);
        if (x.left != null) {
            get(x.left, inList, preList);
        }
        inList.add(x.key);
        if (x.right != null) {
            get(x.right, inList, preList);
        }
    }
}

class Treap{
    int size;
    Node root;
    Treap(int size){
        this.size=size;
    }

    Node rightRotate(Node t){
        Node s = t.left;
        t.left = s.right;
        s.right = t;
        return s;
    }

    Node leftRotate(Node t){
        Node s = t.right;
        t.right = s.left;
        s.left =  t;
        return s;
    }

    Node insert(Node t, int key, int priority){
        if(t==null) return new Node(key, priority);
        if(key==t.key) return t;
        if(key < t.key){
            t.left=insert(t.left, key, priority);
            if(t.priority < t.left.priority){
                t = rightRotate(t);
            }
        }
        else {
            t.right = insert(t.right, key, priority);
            if (t.priority < t.right.priority){
                t = leftRotate(t);
            }
        }
        return t;
    }

    boolean find(int target){
        Node candidate = root;
        while(true){
            if(target < candidate.key){
                if(candidate.left == null){
                    return false;
                }
                else candidate = candidate.left;
            }
            else if(target == candidate.key)return true;
            else{
                if(candidate.right == null){
                    return false;
                }
                else candidate = candidate.right;
            }
        }
    }

    Node delete(Node t, int key){
        if(t==null) return null;
        if(key<t.key) t.left = delete(t.left, key);
        else if(key> t.key) t.right = delete(t.right, key);
        else return _delete(t, key);
        return t;
    }

    Node _delete(Node t, int key){
        if(t.left==null && t.right==null) return null;
        else if(t.left == null) t = leftRotate(t);
        else if(t.right == null) t = rightRotate(t);
        else {
            if(t.left.priority > t.right.priority) t= rightRotate(t);
            else t = leftRotate(t);
        }
        return delete(t, key);
    }


}

class Node{
    int key;
    int priority;
    Node parent;
    Node left;
    Node right;
    Node(int key,int priority){
        this.key=key;
        this.priority=priority;
    }

}