/*
 *  ALDS1_7_B: Binary Tree
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/6/ALDS1_6_B
 */

package ALDS1.ALDS1_7.ALDS1_7_B;
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
            nodes[id].left=sc.nextInt();
            nodes[id].right=sc.nextInt();
            if( nodes[id].left!=-1){
                nodes[nodes[id].left].parent=id;
                nodes[nodes[id].left].sibling=nodes[id].right;

            }
            if( nodes[id].right!=-1){
                nodes[nodes[id].right].parent=id;
                nodes[nodes[id].right].sibling=nodes[id].left;
            }
            nodes[id].degree+=nodes[id].left==-1?0:1;
            nodes[id].degree+=nodes[id].right==-1?0:1;
        }

        int root= -1;
        for(int i=0;i<N;i++){
            if(nodes[i].parent==-1){
                root=i;
                break;
            }
        }
        Queue<Tuple> que =new ArrayDeque<>();
        que.add(new Tuple(nodes[root].left,1));
        que.add(new Tuple(nodes[root].right,1));

        while(!que.isEmpty()){
            Tuple tp=que.poll();
            if(tp.fst==-1) continue;
            nodes[tp.fst].depth=tp.snd;
            que.add(new Tuple(nodes[tp.fst].left,tp.snd+1));
            que.add(new Tuple(nodes[tp.fst].right,tp.snd+1));
        }

        for(int i=0;i<N;i++){
            int height=-1;
            Queue<Integer> q =new ArrayDeque<>();
            q.add(nodes[i].left);
            q.add(nodes[i].right);
            while(!q.isEmpty()){
                int t=q.poll();
                if(t==-1) continue;
                height=Integer.max(height,nodes[t].depth);
                q.add(nodes[t].left);
                q.add(nodes[t].right);
            }
            nodes[i].height=height==-1?0:height-nodes[i].depth;

        }



        StringBuilder sb;
        for (int i=0;i<N;i++){
            sb=new StringBuilder();
            int node=i;
            int parent=nodes[i].parent;
            int sibling=nodes[i].sibling;
            int degree=nodes[i].degree;
            int depth=nodes[i].depth;
            int height=nodes[i].height;
            String type;
            if(parent==-1)type="root";
            else if(degree==0)type="leaf";
            else type="internal node";

            sb.append("node "+node+": "+"parent = "+parent+", sibling = "+sibling+", degree = "+degree+", depth = "+depth+", height = "+height+", "+type);
            System.out.println(sb);
        }

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

class Node{
    int right;
    int left;
    int depth;
    int degree;
    int sibling;
    int parent;
    int height;
    Node(){
        right=left=parent=sibling=-1;
        depth=degree=height=0;
    }
}