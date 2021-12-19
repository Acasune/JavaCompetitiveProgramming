/*
 *  ALDS1_7_A: Rooted Tree
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/7/ALDS1_7_A
 */

package ALDS1.ALDS1_7.ALDS1_7_A;

import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Node[] nodes = new Node[N];
        for (int i=0;i<N;i++){
            nodes[i]=new Node();
        }
        for (int i=0;i<N;i++){
            int id=sc.nextInt();
            int p=sc.nextInt();
            for (int j=0;j<p;j++){
                int k=sc.nextInt();
                nodes[k].parent=id;
                //nodes[k].depth=Integer.max(nodes[k].depth,nodes[id].depth+1);
                nodes[id].children.add(k);
            }
        }

        int root= -1;
        for(int i=0;i<N;i++){
            if(nodes[i].parent==-1){
                root=i;
                break;
            }
        }
        Queue<Tuple> que =new ArrayDeque<>();
        for(int i: nodes[root].children){
            que.add(new Tuple(i,1));
        }
        while(!que.isEmpty()){
            Tuple tp=que.poll();
            nodes[tp.fst].depth=tp.snd;
            for(int nd:nodes[tp.fst].children){
                que.add(new Tuple(nd,tp.snd+1));
            }

        }

        StringBuilder sb;
        for (int i=0;i<N;i++){
            sb=new StringBuilder();
            sb.append("node "+i+": "+"parent = "+nodes[i].parent+", depth = "+nodes[i].depth+", ");
            if(!nodes[i].children.isEmpty()||nodes[i].parent==-1){
                sb.append((nodes[i].parent==-1?"root":"internal node")+", [");
                if(nodes[i].children.size()>0)sb.append(nodes[i].children.get(0));
                for(int j=1;j<nodes[i].children.size();j++){
                    sb.append(", "+nodes[i].children.get(j));
                }
                sb.append("]");
            }
            else{
                sb.append("leaf, []");
            }
            System.out.println(sb);
        }

    }

}

class Node{
    List<Integer> children =new ArrayList<>();
    int parent ;
    int depth;
    Node(){
        this.parent=-1;
        this.depth=0;
    }

}

class Tuple{
    int fst;
    int snd;
    Tuple(int fst,int snd) {
        this.fst=fst;
        this.snd=snd;
    }
}
