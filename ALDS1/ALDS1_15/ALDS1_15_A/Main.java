/*
 *  ALDS1_15_A: Change Making
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_15_A
 */

package ALDS1.ALDS1_15.ALDS1_15_A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    int cnt=0, n;
    private void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cnt+=n/25;
        n=n%25;
        cnt+=n/10;
        n=n%10;
        cnt+=n/5;
        n=n%5;
        cnt+=n;
        System.out.println(cnt);

    }


}
