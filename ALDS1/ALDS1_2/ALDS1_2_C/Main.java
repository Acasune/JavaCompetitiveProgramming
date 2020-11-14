/*
 *  ALDS1_1_C: Prime Numbers
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/1/ALDS1_1_C
 */

package ALDS1.ALDS1_2.ALDS1_2_C;

import java.util.Scanner;

import static java.lang.Integer.*;
import static java.lang.Math.sqrt;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr=new String[n];
		for (int i=0;i<n;i++){
			arr[i]=sc.next();
		}
		String[] arr1= arr.clone(),arr2= arr.clone();
		String[] resultBubbleSort=bubbleSort(arr1);
		System.out.println("Stable");
		String[] resultSelectionSort=selectionSort(arr2);
		for (int i=0;i<n;i++){
			if(resultBubbleSort[i]!=resultSelectionSort[i]){
				System.out.println("Not Stable");
				return;
			}
		}
		System.out.println("Stable");

	}
	private static boolean compare(String s1,String s2){
		return s1.charAt(1)<s2.charAt(1);
	}

	private static String[] bubbleSort(String[] arr){
	  int N=arr.length;
		boolean flag=true;
		while(flag){
			flag=false;
			for (int j=N-1;0<j;j--){
				if(compare(arr[j],arr[j-1])){
					String tmp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=tmp;
					flag=true;
				}
			}
		}
		System.out.printf(arr[0]);
		for(int i=1;i<N;i++){
			System.out.printf(" "+arr[i]);
		}
		System.out.printf("\n");
		return arr;
	}
	private static String[] selectionSort(String[] arr){
		boolean flg=true;
		int N = arr.length;
		while(flg){
			flg=false;
			for (int i=0;i<N;i++){
				int target=i;
				for (int j=target;j<N;j++){
					if(compare(arr[j],arr[target])){
						target=j;
					}
				}
				if(target!=i){
					String tmp=arr[i];
					arr[i]=arr[target];
					arr[target]=tmp;
				}
			}
		}
		System.out.printf(arr[0]);
		for(int i=1;i<N;i++){
			System.out.printf(" "+arr[i]);
		}
		System.out.printf("\n");
		return arr;
	}



}
