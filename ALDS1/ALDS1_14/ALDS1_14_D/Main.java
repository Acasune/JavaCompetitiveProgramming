/*
 *  ALDS1_14_D: Multiple String Matching
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_14_D
 */

package ALDS1.ALDS1_14.ALDS1_14_D;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    static final int MAX_N = 1000000 + 1;
    static int rank[] = new int[MAX_N];
    static int tmp[] = new int[MAX_N];
    static Integer sa[];
    static int n;
    static int k;


    private void run() {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int n = sc.nextInt();
        String Q;
        constructSA(S);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            Q = sc.next();
            sb.append((S.length() >= Q.length() && contain(S,Q))?1:0).append("\n");
        }
        System.out.print(sb);

    }

    boolean compareSA(int i, int j, int n, int k) {
        if(rank[i] != rank[j]) return rank[i] < rank[j];
        else {
            int ri = i + k <= n ? rank[i + k] : -1;
            int rj = j + k <= n ? rank[j + k] : -1;
            return ri < rj;
        }
    }

    void constructSA(String S){
        n = S.length();
        sa = new Integer[n+1];

        Arrays.fill(sa,0);

        for(int i = 0; i <= n; i++){
            sa[i]=i;
            rank[i] = i < n ? S.charAt(i) : -1;
        }

        for (k = 1; k <= n; k *= 2){
            Arrays.sort(sa, new Comparator<Integer>() {
                public int compare(Integer i, Integer j) {
                    if (rank[i] != rank[j])
                        return rank[i] - rank[j];
                    else {
                        int ri = i + k <= n ? rank[i + k] : -1;
                        int rj = j + k <= n ? rank[j + k] : -1;
                        return ri - rj;
                    }
                }
            });

            tmp[sa[0]] = 0;
            for(int i = 1; i <= n; i++){
                tmp[sa[i]] = tmp[sa[i - 1]] + (compareSA(sa[i - 1], sa[i], n, k) ? 1 : 0);
            }

            for (int i = 0; i <= n; i++){
                rank[i] = tmp[i];
            }

        }
    }

    boolean contain(String s, String t){
        int a = 0;
        int b = s.length();
        while(b - a > 1){
            int c = (a + b)/2;
            if((s.substring(sa[c], Math.min(sa[c] + t.length(), s.length()))).compareTo(t) < 0){
                a = c;
            }
            else {
                b = c;
            }
        }
        return (s.substring(sa[b], Math.min(sa[b]+t.length(), s.length()) )).compareTo(t) == 0;
    }
}
