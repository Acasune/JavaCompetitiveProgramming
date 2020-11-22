/*
 *  ALDS1_4_C: Search III
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/4/ALDS1_4_C
 */

package ALDS1.ALDS1_4.ALDS1_4_C;

import java.util.Scanner;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<String> s = new HashSet<String>();
        int n=sc.nextInt();
        for(int i=0; i<n; i++){
            String t=sc.next();
            String r=sc.next();
            if(t.equals("insert")){
                s.add(r);
            }else if(t.equals("find") && s.contains(r)){
                System.out.println("yes");
            }else if(t.equals("find") && !s.contains(r)){
                System.out.println("no");
            }
        }

    }
}