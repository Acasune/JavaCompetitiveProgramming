/*
 *  ALDS1_10_A: Graph
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/11/ALDS1_11_A
 */

package ALDS1.ALDS1_11.ALDS1_11_A;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] G = new int[N][N];
        for (int i=0;i<N;i++)for (int j=0;j<N;j++)G[i][j]=0;
        for(int i =0;i<N;i++){
            int u=sc.nextInt(),k=sc.nextInt();
            for (int j=0;j<k;j++){
                G[i][sc.nextInt()-1]=1;
            }
        }
        for (int i=0;i<N;i++){
            StringBuilder sb= new StringBuilder();
            for (int j=0;j<N;j++){
              if(j==0)sb.append(G[i][j]);
              else sb.append(" "+G[i][j]);
            }
            System.out.println(sb);
        }
    }

}


