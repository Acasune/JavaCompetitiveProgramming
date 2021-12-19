/*
 *  ALDS1_9_A: Complete Binary Tree
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_9_A
 */

package ALDS1.ALDS1_9.ALDS1_9_A;

import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] heap = new int[N];
        for (int i=0; i<N;i++){
            heap[i]=sc.nextInt();
        }
        for (int i=0;i<N;i++){
            if(i==0){
                System.out.printf("node %d: key = %d, left key = %d, right key = %d, \n",i+1,heap[i],heap[2*i+1],heap[2*i+2]);
            }
            else if(2*i+2>=N){
                if(2*i+1==N-1){
                    System.out.printf("node %d: key = %d, parent key = %d, left key = %d, \n",i+1,heap[i],heap[(i-1)/2],heap[2*i+1]);
                }
                else {
                    System.out.printf("node %d: key = %d, parent key = %d, \n",i+1,heap[i],heap[(i-1)/2]);
                }
            }
            else {
                System.out.printf("node %d: key = %d, parent key = %d, left key = %d, right key = %d, \n",i+1,heap[i],heap[(i-1)/2],heap[2*i+1],heap[2*i+2]);
            }
        }

    }
}

