/*
 *  ALDS1_4_D: Allocation
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/4/ALDS1_4_D
 */

// ToDo: Awfully darty code. Refactor is desired

package ALDS1.ALDS1_4.ALDS1_4_D;

import java.util.Scanner;

public class Main {
    static long[] arr;
    static long n,k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();

        arr=new long[(int)n];
        for(int i=0; i<n; i++) {
            arr[i]=sc.nextLong();
        }

        long left=0, right=100_000 * 10_000, mid;
        while(right-left>1){
            mid=(left+right)/2;
            if(judge(mid))right=mid;
            else left=mid;
        }
        System.out.println(right);

    }
    static boolean judge(long P){
        long usedTrucks=0;
        long sumLoad=0;
        for(int i=0;i<n;i++){
            if(arr[i]>P)return false;
            if(sumLoad+arr[i]>P){
                usedTrucks+=1;
                sumLoad=arr[i];
            }
            else{
                sumLoad+=arr[i];
            }
        }
        if(usedTrucks>=k||sumLoad>P)return false;
        else return true;
    }
}