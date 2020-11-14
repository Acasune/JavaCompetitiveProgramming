package ALDS1.ALDS1_1.ALDS1_1_A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static final int BIG_NUM  = Integer.MAX_VALUE;
	public static final int MOD  = 1000000007;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		List<Integer> A = new ArrayList<>();
		for(int i = 0; i < N; i++) A.add(scanner.nextInt());
		System.out.printf("%d", A.get(0));
		for(int k=1;k<N;k++){
			System.out.printf(" %d", A.get(k));
		}
		System.out.printf("\n");
		insertionSort(A,N);
	}

	private static void insertionSort(List<Integer> A, int N){
		int v,j;
		for(int i=1;i<N;i++){
			v = A.get(i);
			j=i-1;
			while(j>=0&&A.get(j)>v){
			  A.set(j+1,A.get(j));
			  j--;
			}
			A.set(j+1,v);
			System.out.printf("%d", A.get(0));
			for(int k=1;k<N;k++){
				System.out.printf(" %d", A.get(k));
			}
			System.out.printf("\n");
		}


	}

}
