/*
 *  ALDS1_3_A: Stack
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/3/ALDS1_3_A
 */

package ALDS1.ALDS1_3.ALDS1_3_A;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {
            Stack<Integer> sk = new Stack<>();
            boolean flg = true;
            while (flg) {
                String in = sc.next();
                if (in.equals("+")) {
                    int a = sk.pop(), b = sk.pop();
                    sk.push(b + a);
                } else if (in.equals("-")) {
                    int a = sk.pop(), b = sk.pop();
                    sk.push(b - a);
                } else if (in.equals("*")) {
                    int a = sk.pop(), b = sk.pop();
                    sk.push(b * a);
                } else {
                    sk.push(parseInt(in));
                }
                flg = sc.hasNext();
            }
            System.out.println(sk.pop());
        }

    }

}
