/*
 *  ALDS1_4_A: Search I
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/4/ALDS1_4_A
 */

package ALDS1.ALDS1_4.ALDS1_4_A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(),ans=0,tmp;
        int[] S=new int[N];
        for (int i=0;i<N;i++){
            S[i]=scanner.nextInt();
        }
        int q = scanner.nextInt();
        for (int i=0;i<q;i++){
            ans+=search(S,scanner.nextInt());
        }
        System.out.println(ans);

    }
    private static int search(int[] S,int target){
      for(int s:S){
          if(s==target){
              return 1;
          }
      }
      return 0;
    }
}
