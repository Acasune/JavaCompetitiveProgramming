/*
 *  ALDS1_11_D: Connected Components
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_11_D
 */

package ALDS1.ALDS1_11.ALDS1_11_D;

import java.util.*;

public class Main {
    static int N,M;
    static int[] connected;
    static List<List<Integer>> G;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        G = new ArrayList<List<Integer>>();
        for (int i=0;i<N;i++){
            G.add(new ArrayList<>());
        }
        for(int i =0;i<M;i++){
            int u=sc.nextInt(),k=sc.nextInt();
            G.get(u).add(k);
            G.get(k).add(u);
        }

        connected = new int[N];
        for (int i=0;i<N;i++)connected[i]=0;

        int groupid=1;

        for(int i=0;i<N;i++){
            if(connected[i]==0){
                dfs(i,groupid);
                groupid++;
            }

        }

        int q=sc.nextInt();

        for (int i=0;i<q;i++){
            System.out.println(connected[sc.nextInt()]==connected[sc.nextInt()]?"yes":"no");
        }
    }

    static void dfs(int input,int groupId){
        Deque<Integer> que = new ArrayDeque<Integer>();
        que.push(input);
        connected[input] = groupId;
        while (!que.isEmpty()) {
            int u = que.poll();
            for (int i = 0; i < G.get(u).size(); i++) {
                int v = G.get(u).get(i);
                if (connected[v] == 0) {
                    connected[v] = groupId;
                    que.push(v);
                }
            }
        }
    }

}