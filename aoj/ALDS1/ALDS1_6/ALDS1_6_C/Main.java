/*
 *  ALDS1_6_C: QuickSort
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/6/ALDS1_6_C
 */

package ALDS1.ALDS1_6.ALDS1_6_C;
import java.util.Scanner;


public class Main {
    static Card[] A,B;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        A=new Card[(int)N];
        B=new Card[(int)N];
        for (int i=0;i<N;i++){
            B[i]=new Card(sc.next().charAt(0),sc.nextInt(),i);
        }
        quickSort(0,N);
        StringBuilder sb = new StringBuilder();
        sb.append(B[0].suite+" "+B[0].num+"\n");
        for (int i = 1; i < N; i++){
            sb.append(B[i].suite+" "+B[i].num).append("\n");
        }
        System.out.println(isStable(B)?"Stable":"Not stable");
        System.out.print(sb);

    }
    private static void quickSort(long p, long r){
        if(p<r){
            long q=partition(p,r);
            quickSort(p,q);
            quickSort(q+1,r);
        }
    }
    private static long partition(long p, long r){
        Card x = B[(int)r-1];
        long i = p;
        for(long j=p;j<r;j++){
            if(B[(int)j].num<=x.num){
                Card tmp=B[(int)i];
                B[(int)i]=B[(int)j];
                B[(int)j]=tmp;
                i+=1;
            }
        }
        return i-1;
    }

    static boolean isStable(Card[] a) {
        for(int i=0;i<a.length-1;i++) {
            if(a[i].num==a[i+1].num&&a[i].idx>a[i+1].idx) {
                return false;
            }
        }
        return true;
    }

}
class Card{
    char suite;
    long num;
    int idx;
    Card(char c, long num,int idx){
        this.suite=c;
        this.num=num;
        this.idx=idx;
    }
}