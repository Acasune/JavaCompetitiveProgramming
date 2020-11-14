/*
 *  ALDS1_1_C: Prime Numbers
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/1/ALDS1_1_C
 */

package ALDS1.ALDS1_1.ALDS1_1_C;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

	public static final int BIG_NUM  = Integer.MAX_VALUE;
	public static final int MOD  = 1000000007;
	public static boolean[] pmTable=new boolean[100000000];

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int tmp,ans=0;
		int[] array=new int[n];
		for (int i=0;i<n;i++){
			tmp=scanner.nextInt();
			if(checkPm(tmp))ans++;
		}
		System.out.println(ans);

	}
	private static boolean checkPm(int a){
		if (a==1)return false;
		if (a==2)return true;
		for (int i=2;i<sqrt(a)+1;i++){
			if(a%i==0)return false;
		}
		return true;
	}



}
