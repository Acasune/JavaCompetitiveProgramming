/*
 *  ALDS1_11_C: Breadth First Search
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_10_C
 */

package ALDS1.ALDS1_11.ALDS1_11_C;

import java.util.*;

public class Main {
    static int N;
    static int[] visited;
    static int[][] G;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        G = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) G[i][j] = 0;
        for (int i = 0; i < N; i++) {
            int u = sc.nextInt(), k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                G[i][sc.nextInt() - 1] = 1;
            }
        }

        visited = new int[N];
        for (int i = 0; i < N; i++) visited[i] = 101;

        Queue<Node> que= new ArrayDeque<>();
        que.add(new Node(0,0));

        while(!que.isEmpty()){
            Node node = que.poll();
            int key=node.key, time=node.time;
            visited[key]=Integer.min(visited[key],time);
            for (int i=0;i<N;i++){
                if(G[node.key][i]==1&&visited[i]==101){
                    que.add(new Node(i,time+1));
                }
            }
        }


        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i + 1).append(" " + (visited[i]==101?-1:visited[i]));
            System.out.println(sb);
        }


    }
}
class Node{
    int key,time;
    Node(int key,int time){
        this.key=key;
        this.time=time;
    }
}