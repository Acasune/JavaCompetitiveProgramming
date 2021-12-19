/*
 *  ALDS1_14_A: Naive String Search
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_14_A
 */

package ALDS1.ALDS1_14.ALDS1_14_A;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        String S = sc.next(), P=sc.next();
        int idxOfP = P.length()-1;
        int idxOfS = P.length()-1;
        while(true){
            if(idxOfS>S.length()-1)break;
            for(int i=idxOfP;0<=i;i--){
                if(i==0){
                    if(P.charAt(i)==S.charAt(idxOfS)){
                      System.out.println(idxOfS);
                    }
                    idxOfP = P.length()-1;
                    idxOfS += P.length();
                    break;
                }
                else if(P.charAt(i)!=S.charAt(idxOfS)){
                    idxOfP = P.length() - 1;
                    idxOfS += P.length() - i;
                    break;
                }
                idxOfS--;
            }
        }
    }
}
