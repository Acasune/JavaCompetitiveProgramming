/*
 *  ALDS1_10_B: Matrix Chain Multiplication
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_10_B
 */

package ALDS1.ALDS1_10.ALDS1_10_B;

import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] A = new int[N][2], dp=new int[N][N];

        for (int i=0;i<N;i++){
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        for(int i=0;i<N-1;i++)for (int j=0;j<N;j++) dp[i][j]=0;

        for(int i=0;i<N-1;i++){
            dp[i][i+1]=A[i][0]*A[i][1]*A[i+1][1];
        }
        for (int l=2;l<N;l++){
            for (int i=0;i<N-l;i++){
                int j =  i + l;
                int minCost=Integer.MAX_VALUE;
                for (int k = i;k<j;k++){
                    minCost=Integer.min(minCost, dp[i][k]+dp[k+1][j]+A[i][0]*A[k][1]*A[j][1]);
                }
                dp[i][j]=minCost;
            }
        }

        System.out.println(dp[0][N-1]);

    }


}
