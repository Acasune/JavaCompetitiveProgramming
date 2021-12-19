/*
 *  ALDS1_14_B: String Search
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_14_B
 */

package ALDS1.ALDS1_14.ALDS1_14_B;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    static final int B = 100_000_007;

    private void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), p=sc.next();
        int sl=s.length(), pl=p.length();
        if(pl>sl) return;

        long t = 1;
        for(int i=0;i<pl;i++){
            t *= B;
        }

        long ph = 0, sh=0;
        for(int i=0;i<pl;i++){
            ph = ph * B + p.charAt(i);
        }
        for(int i=0;i<pl;i++){
            sh = sh * B + s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i +pl<=sl;i++){
            if(ph==sh) sb.append(i+"\n");
            if(i + pl < sl) sh=sh * B + s.charAt(i+pl) - s.charAt(i)*t;
        }
        System.out.print(sb);
    }
}
