/*
 *  ALDS1_7_D: Reconstruction of a Tree
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_7_D
 */

package ALDS1.ALDS1_7.ALDS1_7_D;
import java.util.Scanner;


public class Main {
    static int[] Pre, In, Post;
    static int pos,postPos;
    static boolean[] echoed;
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      Pre = new int[N];
      In = new int[N];
      Post = new int[N];
      postPos=0;

      for (int i=0;i<N;i++){
        Pre[i]=sc.nextInt();
      }

      for (int i=0;i<N;i++){
        In[i]=sc.nextInt();
      }

      reconstruction(0,N);
      StringBuilder sb=new StringBuilder();

      for (int i=0;i<N;i++){
        if(i==0)sb.append(Post[i]);
        else sb.append(" ").append(Post[i]);
      }

      System.out.println(sb);

    }
    private static void reconstruction(int left, int right){
      if (left >= right) return;
      int root, rootPos;
      root = Pre[pos++];
      rootPos = left;
      for (int i = left; i< right; i++){
        if(In[i]==root){
          rootPos=i;
        }
      }

      reconstruction(left, rootPos);
      reconstruction(rootPos+1, right);

      Post[postPos]=root;
      postPos++;

    }
}

