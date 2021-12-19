/*
 *  ALDS1_10_C: Longest Common Subsequence
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_10_C
 */

package ALDS1.ALDS1_10.ALDS1_10_C;

import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int z=0;z<N;z++){
            String S1=sc.next(), S2=sc.next();
            int n1=S1.length(), n2=S2.length();
            int[][] dp=new int[n1+1][n2+1];
            for (int i=0;i<n1+1;i++)for (int j=0;j<n2+1;j++){
                dp[i][j]=0;
            }
            for (int i=0;i<n1;i++)for (int j=0;j<n2;j++){
                if(S1.charAt(i)==S2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }
                else {
                    dp[i + 1][j + 1] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
            System.out.println(dp[n1][n2]);

        }

    }


}

