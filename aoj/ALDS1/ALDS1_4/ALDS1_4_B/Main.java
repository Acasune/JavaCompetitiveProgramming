/*
 *  ALDS1_4_B: Search II
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/4/ALDS1_4_B
 */

package ALDS1.ALDS1_4.ALDS1_4_B;
import java.util.Scanner;


public class Main {
    static int[] S;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(),ans=0,tmp;
        S=new int[N];
        for (int i=0;i<N;i++){
            S[i]=scanner.nextInt();
        }
        int q = scanner.nextInt();
        for (int i=0;i<q;i++){
            ans+=binarySearch(0,N,scanner.nextInt());
        }
        System.out.println(ans);

    }
    private static int binarySearch(int left, int right,int target){
        if(right-left<=1&&S[left]==target) return 1;
        if(right-left<=1&&S[left]!=target) return 0;
        if(S[(right+left)/2]>target)  return binarySearch(left,(right+left)/2,target);
        else return binarySearch((right+left)/2,right,target);
    }
}
