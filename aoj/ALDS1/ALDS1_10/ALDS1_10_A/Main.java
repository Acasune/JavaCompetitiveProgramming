/*
 *  ALDS1_10_A: Fibonacci Number
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_10_A
 */

package ALDS1.ALDS1_10.ALDS1_10_A;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fibos ins=new Fibos();
        System.out.println(ins.calcFib(sc.nextInt()));
    }

}

class Fibos{
    int[] memo=new int[45];
    Fibos(){
        for (int i=0;i<45;i++){
            memo[i]=-1;
        }
    }
    int calcFib(int n){
        if(n==0||n==1) return 1;
        if(memo[n]!=-1) return memo[n];
        return memo[n]=calcFib(n-1)+calcFib(n-2);
    }


}

