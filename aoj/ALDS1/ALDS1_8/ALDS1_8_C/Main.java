/*
 *  ALDS1_8_C: Binary Search Tree Ⅲ
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_8_C
 */

package ALDS1.ALDS1_8.ALDS1_8_C;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        BinaryTree tree = new BinaryTree(N);

        for (int i = 0; i < N; i++) {
            String type = sc.next();
            if (type.equals("insert")) {
                if (tree.root == null) {
                    tree.root = new Node(sc.nextInt());
                } else {
                    tree.insert(sc.nextInt());
                }
            }
            else if (type.equals("find")){
                System.out.println(tree.find(sc.nextInt())?"yes":"no");
            }
            else if(type.equals("delete")){
                tree.delete(sc.nextInt());
            }
            else {
                StringBuilder sb = new StringBuilder();
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
                System.out.print(sb);
            }
        }

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

    boolean find(int target){
        Node candidate = root;
        while(true){
            if(target < candidate.num){
                if(candidate.left == null){
                    return false;
                }
                else candidate = candidate.left;
            }
            else if(target == candidate.num)return true;
            else{
                if(candidate.right == null){
                    return false;
                }
                else candidate = candidate.right;
            }
        }
    }

    void delete(int key){
        Node parent = null;
        Node child = root;

        while(child != null && child.num != key){
            parent = child;
            if(key < parent.num){
                child = parent.left;
            }
            else{
                child = parent.right;
            }

        }

        if(child==null) return;

        if(child.left==null){
            if(key<parent.num) parent.left = child.right;
            else parent.right = child.right;
        }
        else if(child.right == null){
            if(key<parent.num) parent.left = child.left;
            else parent.right = child.left;
        }
        else {
            parent = child;
            Node nextNode = child.right;
            while (nextNode.left != null) {
                parent = nextNode;
                nextNode = nextNode.left;
            }
            child.num = nextNode.num;
            if (nextNode.num < parent.num) parent.left = nextNode.right;
            else parent.right = nextNode.right;
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