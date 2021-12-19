/*
 *  ALDS1_2_B: Selection Sort
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/2/ALDS1_2_B
 */

package ALDS1.ALDS1_2.ALDS1_2_B;

import java.util.Scanner;

public class Main {

	public static final int BIG_NUM  = Integer.MAX_VALUE;
	public static final int MOD  = 1000000007;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int cnt = selectionSort(arr);
		System.out.println(cnt);

	}

	private static int selectionSort(int[] arr){
		int cnt=0;
		boolean flg=true;
		while(flg){
			flg=false;
			for (int i=0;i<arr.length;i++){
				int target=i;
				for (int j=target;j<arr.length;j++){
					if(arr[j]<arr[target]){
						target=j;
					}
				}
				if(target!=i){
					cnt++;
					int tmp=arr[i];
					arr[i]=arr[target];
					arr[target]=tmp;
				}
			}
		}
		System.out.printf("%d",arr[0]);
		for (int i=1;i<arr.length;i++){
			System.out.printf(" %d",arr[i]);
		}
		System.out.printf("\n");
		return cnt;
	};


}
