/*
 *  ALDS1_2_D: Maximum Profit
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/1/ALDS1_1_D
 */

package ALDS1.ALDS1_2.ALDS1_2_D;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array=new int[n];
		for (int i=0;i<n;i++){
			array[i]=sc.nextInt();
		}
		int ans =solve(array,n);
		System.out.println(ans);
	}
	private static int solve(int[] arr,int n){
		int[] minArr=new int[n], maxArr=new int[n];
		minArr[0]=arr[0];
		maxArr[n-1]=arr[n-1];
		for (int i=1;i<n;i++){
			minArr[i]=min(minArr[i-1],arr[i]);
		}
		for (int i=n-2;-1<i;i--){
			maxArr[i]=max(maxArr[i+1],arr[i]);
		}
		int ans=-1_000_000_000;
		for (int i=0;i<n-1;i++){
			ans=max(-minArr[i]+maxArr[i+1],ans);
		}
		return ans;
	}
}
