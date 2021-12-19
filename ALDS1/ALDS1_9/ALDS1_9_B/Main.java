/*
 *  ALDS1_9_B: Maximum Heap
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_9_B
 */

package ALDS1.ALDS1_9.ALDS1_9_B;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];

        for (int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        buildMaxHeap();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(" ").append(A[i]);
        }
        System.out.println(sb);

    }
    static void maxHeapify(int i){
        int l = Integer.min(2*i+1,N);
        int r = Integer.min(2*i+2,N);
        int largest=i;
        if (l!=N&&A[i]<A[l]){
            largest = l;
        }
        if(r!=N&&A[largest]<A[r]){
            largest = r;
        }
        if(largest!=i){
            int tmp=A[i];
            A[i]=A[largest];
            A[largest]= tmp;
            maxHeapify(largest);
        }
    }
    static void buildMaxHeap(){
        for(int i = N/2;0<=i;i--){
            maxHeapify(i);
        }
    }

}
