/*
 *  ALDS1_11_B: Single Source Shortest Path Ⅱ
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_12_C
 */

package ALDS1.ALDS1_12.ALDS1_12_C;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int INF=Integer.MAX_VALUE/10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] cost = new int[N][N];
        for (int i=0;i<N;i++)for (int j=0;j<N;j++)cost[i][j]=INF;
        for (int i=0;i<N;i++){
            int u=sc.nextInt(), k=sc.nextInt();
            for (int j=0;j<k;j++){
                int v=sc.nextInt(), c=sc.nextInt();
                cost[u][v]=c;
            }
        }

        boolean[] used = new boolean[N];
        int[] minCost = new int[N];
        Arrays.fill(used, false);
        Arrays.fill(minCost,INF);
        minCost[0] = 0;

        while (true){
            int v=-1;
            for (int u=0; u<N;u++){
                if(!used[u]&&(v==-1||minCost[u]<minCost[v]))v=u;
            }

            if(v==-1) break;
            used[v]=true;

            for (int u=0; u<N;u++){
                minCost[u] = Integer.min(minCost[u],minCost[v]+cost[v][u]);
            }

        }

        for (int i=0;i<N;i++){
            System.out.println(i+" "+minCost[i]);
        }

    }

}