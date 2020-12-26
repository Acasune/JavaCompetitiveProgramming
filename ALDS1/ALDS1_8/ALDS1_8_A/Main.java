/*
 *  ALDS1_8_A: Binary Search Tree Ⅰ
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_8_A
 */

package ALDS1.ALDS1_8.ALDS1_8_A;

import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        BinaryTree tree = new BinaryTree(N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String type = sc.next();
            if (type.equals("insert")) {
                if (tree.root == null) {
                    tree.root = new Node(sc.nextInt());
                } else {
                    tree.insert(sc.nextInt());
                }
            } else {
                ArrayList<Integer> inList = new ArrayList<>();
                ArrayList<Integer> preList = new  ArrayList<>();
                get(tree.root, inList, preList);
                for (int x : inList) {
                    sb.append(" ").append(x);
                }
                sb.append("\n");
                for (int x : preList) {
                    sb.append(" ").append(x);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);

    }
    static void get(Node x, ArrayList<Integer> inList, ArrayList<Integer> preList) {
        preList.add(x.num);
        if (x.left != null) {
            get(x.left, inList, preList);
        }
        inList.add(x.num);
        if (x.right != null) {
            get(x.right, inList, preList);
        }
    }
}

class BinaryTree{
    int size;
    Node root;
    BinaryTree(int size){
        this.size=size;
    }

    void insert(int a){
        Node node = new Node(a);
        Node parent = root;
        while(true){
            if(a<parent.num){
                if(parent.left==null){
                    node.parent=parent;
                    parent.left=node;
                    return;
                }
                parent=parent.left;
            }
            else{
                if(parent.right==null){
                    node.parent=parent;
                    parent.right=node;
                    return;
                }
                parent=parent.right;
            }
        }
    }
}

class Node{
    int num;
    Node parent;
    Node left;
    Node right;
    Node(int num){
        this.num=num;
    }

}