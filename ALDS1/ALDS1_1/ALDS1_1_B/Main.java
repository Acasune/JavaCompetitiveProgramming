/*
 *  ALDS1_1_B: Greatest Common Divisor
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/1/ALDS1_1_B
 */

package ALDS1.ALDS1_1.ALDS1_1_B;

import java.util.Scanner;

import static java.lang.Integer.min;
import static java.lang.Integer.max;

public class Main {

	public static final int BIG_NUM  = Integer.MAX_VALUE;
	public static final int MOD  = 1000000007;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int ans = gcd(max(a,b),min(a,b));
		System.out.println(ans);

	}

	private static int gcd(int a,int b){
		if ( a%b==0){
			return b;
		}
		return gcd(b,a%b);
	};


}
