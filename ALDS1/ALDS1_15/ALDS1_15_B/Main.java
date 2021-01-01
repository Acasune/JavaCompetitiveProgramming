/*
 *  ALDS1_15_B: Fractional Knapsack Problem
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_15_B
 */

package ALDS1.ALDS1_15.ALDS1_15_B;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];

        for (int i = 0 ; i < N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[1];
            }
        });
        int ans = 1;
        int right = arr[0][1];

        for (int i = 1; i < N; i++) {
            if (right < arr[i][0]){
                ans++;
                right = arr[i][1];
            }

        }

        System.out.println(ans);
    }

}
