package ALDS1.ALDS1_2.ALDS1_2_A;

import java.util.Scanner;

public class Main {

    public static final int BIG_NUM  = Integer.MAX_VALUE;
    public static final int MOD  = 1000000007;
    public static boolean[] pmTable=new boolean[100000000];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr=new int[N];
        for (int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        bubbleSort(arr,N);

    }
    private static void bubbleSort(int[] arr,int N){
        int cnt=0;
        boolean flag=true;
        while(flag){
            flag=false;
            for (int j=arr.length-1;0<j;j--){
                if(arr[j]<arr[j-1]){
                    int tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                    cnt++;
                    flag=true;
                }
            }
        }

        System.out.printf("%d",arr[0]);
        for(int i=1;i<N;i++){
            System.out.printf(" %d",arr[i]);
        }
        System.out.printf("\n");
        System.out.println(cnt);


    }



}
