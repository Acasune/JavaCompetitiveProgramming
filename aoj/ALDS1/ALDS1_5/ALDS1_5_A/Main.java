/*
 *  ALDS1_5_A: Exhaustive Search
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/5/ALDS1_5_A
 */

package ALDS1.ALDS1_5.ALDS1_5_A;

import java.util.Scanner;

public class Main {
    static long[] arr;
    static long N;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr=new long[(int)N];
        for (int i=0;i<N;i++){
            arr[i]=sc.nextLong();
        }
        int q = sc.nextInt();
        for (int i=0;i<q;i++){
            if(dfs(0,0,sc.nextLong())) System.out.println("yes");
            else System.out.println("no");
        }

    }
    private static boolean dfs(long idx,long sum, long target){
        if(idx==N){
            if(sum==target) return true;
            else return false;
        }
        return dfs(idx+1,sum,target)||dfs(idx+1,sum+arr[(int)idx],target);
    }
}
