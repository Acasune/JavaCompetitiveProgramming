/*
 *  ALDS1_9_C: Priority Queue
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_9_C
 */

package ALDS1.ALDS1_9.ALDS1_9_C;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap heap=new Heap();

        while(true){
            String type = sc.next();
            if (type.equals("insert")) {
                heap.insert(sc.nextInt());
            }
            else if (type.equals("extract")){
                System.out.println(heap.extract());
            }
            else{

                return ;
            }
        }
    }
}

class Heap{
    int size=2_000_001;
    int idx=0;
    int[] heap = new int[size];
    Heap(){
        for(int i=0; i<size;i++){
            heap[i]=-1;
        }
    }

    void insert(int t){
        int i=idx;
        while(i>0){
            int p=(i-1)/2;
            if(heap[p]>=t) break;
            heap[i]=heap[p];
            i=p;
        }
        heap[i]=t;
        idx++;
    }
    int extract(){
        int ret = heap[0];
        int x = heap[--idx];

        int i=0;
        while(i*2+1<idx){
            int a=i*2+1, b=i*2+2;
            if(b<idx && heap[b]>=heap[a]) a=b;
            if(heap[a]<x) break;

            heap[i]=heap[a];
            i=a;
        }
        heap[i]=x;
        return ret;
    }

}