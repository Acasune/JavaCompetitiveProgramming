/*
 *  ALDS1_2_D: Shell Sort
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/2/ALDS1_2_D
 */

package ALDS1.ALDS1_2.ALDS1_2_D;

import java.util.Scanner;


public class Main {
	static int[] A,G;
	static int cnt=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A=new int[N];
		for (int i=0;i<N;i++){
			A[i]=sc.nextInt();
		}
		shellSort(N);
		System.out.println(cnt);
		for (int i=0;i<N;i++){
			System.out.println(A[i]);
		}
	}

	private static void shellSort(int n){
		int[] tmpG=new int[n];
		int sizeG=0, h=1;
		while(true){
			if(h>n)break;
			tmpG[sizeG]=h;
			sizeG++;
			h=3*h+1;
		}
		G=new int[sizeG];
		for(int i=0;i<sizeG;i++){
			G[i]=tmpG[sizeG-i-1];
		}
		System.out.println(sizeG);
		System.out.print(G[0]);
		for(int i=1;i<sizeG;i++){
			System.out.print(" "+G[i]);
		}
		System.out.println();
		for(int i=0;i<sizeG;i++){
			insertionSort(n,G[i]);
		}

	}

	private static void insertionSort(int n, int g){
		for(int i=g;i<=n-1;i++){
			int v=A[i];
			int j= i-g;
			while(j>=0 && A[j]>v){
				A[j+g]=A[j];
				j=j-g;
				cnt++;
			}
			A[j+g]=v;
		}
	}
}
