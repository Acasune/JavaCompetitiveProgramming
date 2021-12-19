/*
 *  ALDS1_6_A: Counting Sort
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/6/ALDS1_6_A
 */

package ALDS1.ALDS1_6.ALDS1_6_A;

import java.util.Scanner;

public class Main {
    static long[] A,B;
    static long N;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A=new long[(int)N];
        B=new long[(int)N];
        long k = - 1;
        for (int i=0;i<N;i++){
            A[i]=sc.nextLong();
            k=Long.max(k,A[i]);
        }

        countingSort(N,k);

        StringBuilder sb = new StringBuilder();
        sb.append(B[0]);

        for (int i = 1; i < N; i++)
          sb.append(" " + B[i]);

        System.out.println(sb);

//        System.out.print(B[0]);
//        for(int i=1;i<N;i++){
//          System.out.print(" "+B[i]);
//        }
//        System.out.print("\n");
    }
    private static void countingSort(long size, long upper){
      long[] C = new long[(int)upper+1];
      int i;
      for(i=0;i<upper+1;i++){
          C[i]=0;
      }
      for(i=0;i<size;i++){
          C[(int)A[i]]++;
      }
      for(i=1;i<upper+1;i++){
        C[i]+=C[i-1];
      }
      for(i=(int)size-1;0<=i;i--){
        B[(int)C[(int)A[i]]-1]=A[i];
        C[(int)A[i]]--;
      }
    }
}
