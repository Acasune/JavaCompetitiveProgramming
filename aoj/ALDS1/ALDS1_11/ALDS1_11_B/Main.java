/*
 *  ALDS1_11_B: Depth First Search
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/11/ALDS1_11_B
 */

package ALDS1.ALDS1_11.ALDS1_11_B;

import java.util.Scanner;

public class Main {
    static int time=0,N;
    static int[][] G, visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        G = new int[N][N];
        for (int i=0;i<N;i++)for (int j=0;j<N;j++)G[i][j]=0;
        for(int i =0;i<N;i++){
            int u=sc.nextInt(),k=sc.nextInt();
            for (int j=0;j<k;j++){
                G[i][sc.nextInt()-1]=1;
            }
        }

        visited = new int[N][2];
        for (int i=0;i<N;i++)for (int j=0;j<2;j++)visited[i][j]=0;

        for(int i=0;i<N;i++)dfs(i);

        for (int i=0;i<N;i++){
            StringBuilder sb= new StringBuilder();
            sb.append(i+1).append(" "+visited[i][0]).append(" "+visited[i][1]);
            System.out.println(sb);
        }
    }

    static void dfs(int input){
        if(visited[input][0]!=0) return;
        visited[input][0]=++time;
        for (int i=0;i<N;i++){
            if(G[input][i]==1&&visited[i][0]==0){
                dfs(i);
            }
        }
        visited[input][1]=++time;
    }

}