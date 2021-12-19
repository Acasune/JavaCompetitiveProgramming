/*
 *  ALDS1_5_C: Koch Curve
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/5/ALDS1_5_C
 */

package ALDS1.ALDS1_5.ALDS1_5_C;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        curb((float) 0, (float) 0, (float) 100, (float) 0, n);
        System.out.println((double) 100 + " " + (double) 0);

        scan.close();
        System.exit(0);
    }

    private static void curb(double x1, double y1, double x2, double y2, int n) {
        if (n == 0) {
            System.out.println(x1 + " " + y1);
            return;
        }

        double r3 = Math.pow(3, 0.5);

        double d1x = x1 + (x2 - x1) / 3;
        double d1y = y1 + (y2 - y1) / 3;
        curb(x1, y1, d1x, d1y, n - 1);

        double d2x = d1x + (x2 - x1) / 6 - (y2 - y1) * r3 / 6;
        double d2y = d1y + (y2 - y1) / 6 + (x2 - x1) * r3 / 6;
        curb(d1x, d1y, d2x, d2y, n - 1);

        double d3x = x1 + (x2 - x1) / 3 * 2;
        double d3y = y1 + (y2 - y1) / 3 * 2;
        curb(d2x, d2y, d3x, d3y, n - 1);

        curb(d3x, d3y, x2, y2, n - 1);

    }
}