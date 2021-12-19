/*
 *  ALDS1_6_B: Partition
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/6/ALDS1_6_B
 */

package ALDS1.ALDS1_6.ALDS1_6_B;
import java.util.Scanner;


public class Main {
    static long[] A;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        A=new long[(int)N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        long idx=partition(0,N);

        StringBuilder sb = new StringBuilder();
        if(idx==0){
            sb.append("[").append(A[0]).append("]");
        }
        else {
            sb.append(A[0]);
        }
        for (int i = 1; i < N; i++){
            if(idx==i){
                sb.append(" [").append(A[i]).append("]");
            }
            else {
                sb.append(" ").append(A[i]);
            }
        }
        System.out.println(sb);

    }
    private static long partition(long p, long r){
        long x = A[(int)r-1];
        long i = p;
        for(long j=p;j<r;j++){
            if(A[(int)j]<=x){
                long tmp=A[(int)i];
                A[(int)i]=A[(int)j];
                A[(int)j]=tmp;
                i+=1;
            }
        }
        return i-1;
    }

}
