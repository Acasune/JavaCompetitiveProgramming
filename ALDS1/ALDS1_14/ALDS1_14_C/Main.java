/*
 *  ALDS1_14_C: Pattern Search
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_14_C
 */

package ALDS1.ALDS1_14.ALDS1_14_C;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    static final int B1 = 9973;
    static final int B2 = 100_000_007;
    int H,W,R,C;


    private void run() {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W=sc.nextInt();
        String[] field = new String[H];
        for(int h=0;h<H;h++){
            field[h]=sc.next();
        }

        R=sc.nextInt();
        C=sc.nextInt();
        String[] pattern = new String[R];
        for(int r=0;r<R;r++){
            pattern[r]=sc.next();
        }

        if(R>H||C>W) return;

        int[][] hash = new int[H][W], tmp = new int[H][W];

        // Make Hash table of the Pattern
        int t1 = 1;
        for(int i=0;i<C;i++){
            t1 *= B1;
        }
        for(int i = 0; i < R; i++){
            int e = 0;
            for(int j = 0; j < C; j++) e = e * B1 + pattern[i].charAt(j);
            for(int j = 0; j + C<=C; j++){
                tmp[i][j] = e;
                if(j + C < C) e = e * B1 - t1 * pattern[i].charAt(j) + pattern[i].charAt(j + C);
            }
        }

        int t2 = 1;
        for(int i = 0; i < R; i++){
            t2 *= B2;
        }
        for(int j = 0; j + C <= C; j++){
            int e = 0;
            for(int i = 0; i < R; i++) e = e * B2 + tmp[i][j];
            for(int i = 0; i + R<=R; i++){
                hash[i][j] = e;
                if(j + C < C) e = e * B2 - t2 * tmp[i][j] + tmp[i+R][j];
            }
        }

        //Make Hash table of the Field
        int hashOfPattern=hash[0][0];

        t1 = 1;
        for(int i=0; i < C ; i++){
            t1 *= B1;
        }
        for(int i = 0; i < H; i++){
            int e = 0;
            for(int j = 0; j < C; j++) e = e * B1 + field[i].charAt(j);
            for(int j = 0; j + C <= W; j++){
                tmp[i][j] = e;
                if(j + C < W) e = e * B1 - t1 * field[i].charAt(j) + field[i].charAt(j+C);
            }
        }

        t2 = 1;
        for(int i=0;i<R;i++){
            t2 *= B2;
        }

        for(int j = 0; j + C <= W; j++){
            int e = 0;
            for(int i = 0; i < R; i++) e = e * B2 + tmp[i][j];
            for(int i = 0; i + R <= H; i++){
                hash[i][j] = e;
                //if(hashOfPattern == e) sb.append(i+ " "+j+"\n");
                if(i + R < H) {
                    e = e * B2 - t2 * tmp[i][j] + tmp[i+R][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i + R <= H; i++){
            for (int j = 0; j + C <= W; j++){
                if(hashOfPattern == hash[i][j] ) sb.append(i+ " "+j+"\n");
            }
        }
        System.out.print(sb);


    }
}
