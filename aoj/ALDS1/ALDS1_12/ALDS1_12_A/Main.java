/*
 *  ALDS1_11_A: Minimum Spanning Tree
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_12_A
 */

package ALDS1.ALDS1_12.ALDS1_12_A;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] cost = new int[N][N];
        for (int i=0;i<N;i++)for (int j=0;j<N;j++)cost[i][j]=sc.nextInt();

        int res=0;
        boolean[] used=new boolean[N];
        int[] minCost = new int[N];
        Arrays.fill(used, false);
        Arrays.fill(minCost,Integer.MAX_VALUE);

        minCost[0]=0;
        while (true){
            int v=-1;
            for (int u=0; u<N;u++){
                if(!used[u]&&(v==-1||minCost[u]<minCost[v]))v=u;
            }

            if(v==-1) break;
            used[v]=true;
            res+=minCost[v];

            for (int u=0; u<N;u++){
                if(cost[v][u]==-1)continue;
                minCost[u] = Integer.min(minCost[u], cost[v][u]);
            }

        }

        System.out.println(res);

    }

}
