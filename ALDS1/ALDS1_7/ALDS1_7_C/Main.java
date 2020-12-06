/*
 *  ALDS1_7_C: Tree Walk
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/7/ALDS1_7_C
 */

package ALDS1.ALDS1_7.ALDS1_7_C;
import java.util.Scanner;


public class Main {
    static TreeNode[] T;
    static String S="";
    static boolean[] echoed;
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      T=new TreeNode[N];

      for (int i=0;i<N;i++){
        T[i]=new TreeNode();
      }

      for (int i=0;i<N;i++){
        int a=sc.nextInt(), b=sc.nextInt(), c=sc.nextInt();
        if(b!=-1) T[b].parent=a;
        if(c!=-1) T[c].parent=a;
        T[a].left=b;
        T[a].right=c;
      }
      int top=-1;
      for (int i=0;i<N;i++){
        if(T[i].parent==-1){
          top=i;
          break;
        }

      }

      System.out.println("Preorder");
      preorder(top);
      System.out.println(S);

      System.out.println("Inorder");
      S="";
      echoed=new boolean[N];
      for (int i=0;i<N;i++){
        echoed[i]=false;
      }
      inorder(top);
      System.out.println(S);

      System.out.println("Postorder");
      S="";
      echoed=new boolean[N];
      for (int i=0;i<N;i++){
        echoed[i]=false;
      }
      postorder(top);
      System.out.println(S);

    }
    private static void preorder(int t){
        S+=" "+t;
        if(T[t].left!=-1) preorder(T[t].left);
        if(T[t].right!=-1) preorder(T[t].right);
    }

    private static void inorder(int t){
      if(t==-1) return;
      if(T[t].left!=-1&&!echoed[T[t].left]){
        inorder(T[t].left);
        return;
      }
      if(!echoed[t])
        S+=" "+t;
      echoed[t]=true;

      if(T[t].right==-1||echoed[T[t].right]){
        inorder(T[t].parent);
      }
      else{
        inorder(T[t].right);
      }

    }

    private static void postorder(int t){
      if(t==-1) return;
      if(T[t].left!=-1&&!echoed[T[t].left]){
        postorder(T[t].left);
        return;
      }
      else{
        if (T[t].right!=-1&&!echoed[T[t].right]){
          postorder(T[t].right);
          return;
        }
        else{
          S+=" "+t;
          echoed[t]=true;
          postorder(T[t].parent);
          return ;
        }
      }
    }


}

class TreeNode{
    int left;
    int right;
    int parent;
    TreeNode(){
        parent=-1;
    }
}