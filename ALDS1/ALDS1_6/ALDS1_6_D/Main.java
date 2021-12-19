/*
 *  ALDS1_6_D: Minimum Cost Sort
 *  URL:https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_6_D
 */

package ALDS1.ALDS1_6.ALDS1_6_D;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;


public class Main {
    static long[] A,B;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A=new long[N];
        B=new long[N];
        boolean[] visited=new boolean[N];
        for (int i=0;i<N;i++){
            A[i]=B[i]=sc.nextInt();
        }
        long ans=0;
        long smallest=100000;
        Arrays.sort(A);
        for (int i=0;i<N;i++){
            if(A[i]==B[i])visited[i]=true;
            smallest=min(smallest,B[i]);
        }
        for(int i=N-1;-1<i;i--){
            if(B[i]==A[i]||visited[i])continue;
            int idx=i;
            int groupSize=1;
            long minload=B[i];
            long pair=B[i];
            visited[i]=true;
            ans+=B[i];
            while(true){
                boolean flag=false;
                for (int j=0;j<i;j++){
                    if(!visited[j]&&B[j]!=A[j]&&A[j]==pair){
                        minload=min(minload,B[j]);
                        visited[j]=true;
                        ans+=B[j];
                        pair=B[j];
                        groupSize+=1;
                        idx=j;
                        flag=true;
                        break;
                    }

                }
                if(!flag) break;
            }
            if(groupSize>=3){
                ans+=min(minload*(groupSize-2),minload+smallest*(groupSize+1));
            }

        }

        System.out.println(ans);

    }


}

