/*
 *  ALDS1_3_B: Queue
 *  URL: https://onlinejudge.u-aizu.ac.jp/solutions/problem/ALDS1_3_B
 */

package ALDS1.ALDS1_3.ALDS1_3_B;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q=sc.nextInt() ;
        Queue<Ps> que=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            String a=sc.next();
            int b=sc.nextInt();
            que.add(new Ps(a,b));
        }
        int totalTime=0;
        while(!que.isEmpty()){
            Ps p=que.remove();
            if(p.t<=q){
                totalTime+=p.t;
                System.out.println(p.q+" "+totalTime);
            }
            else{
                p.t-=q;
                totalTime+=q;
                que.add(p);
            }
        }

    }
    private static class Ps{
        public String q;
        public int t;
        Ps(String q, int t){
            this.q=q;
            this.t=t;
        }
    }

}
