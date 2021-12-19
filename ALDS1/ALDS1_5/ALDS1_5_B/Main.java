/*
 *  ALDS1_5_B: Merge Sort
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/5/ALDS1_5_B
 */

package ALDS1.ALDS1_5.ALDS1_5_B;
import java.util.Scanner;


public class Main {
    static long[] S;
    static Long ans=0L;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextInt(),ans=0;
        S=new long[(int)N];
        for (int i=0;i<N;i++){
            S[i]=scanner.nextInt();
        }
        mergeSort(0,N);
        System.out.print(S[0]);
        for(int i=1;i<N;i++){
            System.out.print(" "+S[i]);
        }
        System.out.print("\n");
        System.out.println(Main.ans);

    }
    private static void mergeSort(long left, long right){
        if(left+1<right){
            long mid = (left+right)/2;
            mergeSort(left,mid);
            mergeSort(mid,right);
            merge(left,mid, right);
        }
    }
    private static void merge(long left, long mid, long right){
        long n1 = mid - left, n2 = right - mid;
        long[] L=new long[(int)n1], R=new long[(int)n2];
        for (int i = 0;i<n1;i++){
            L[i] = S[(int)left + i];
        }
        for (int i = 0;i<n2;i++){
            R[i] = S[(int)mid + i];
        }
        long i=0,j=0;
        for(long k=left;k<right;k++){
            ans++;
            if(j==n2){
                S[(int)k]=L[(int)i];
                i++;
            }
            else if(i==n1){
                S[(int)k]=R[(int)j];
                j++;
            }
            else if(L[(int)i]<=R[(int)j]){
                S[(int)k]=L[(int)i];
                i++;
            }
            else{
                S[(int)k]=R[(int)j];

                j++;
            }
        }
    }
}
