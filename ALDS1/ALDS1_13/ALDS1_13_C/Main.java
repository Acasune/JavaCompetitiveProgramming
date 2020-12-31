/*
 *  ALDS1_13_B: 15 Puzzle
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_13_C
 */

package ALDS1.ALDS1_13.ALDS1_13_C;

import java.util.*;

public class Main {

    final int[][] dyx={{0,1},{0,-1},{1,0},{-1,0}};
    int[][] goal = new int[4][4], start = new int[4][4];
    Map<String, Integer> mp=new HashMap<>();

    public static void main(String[] args) {
        new Main().run();
    }

    class Puzzle{
        int count;
        int[][] p=new int[4][4];
        Puzzle(int[][] p, int count){
            this.count=count;
            for(int i = 0 ; i < 4 ; i++) {
                for(int j = 0; j < 4; j++){
                    this.p[i][j]=p[i][j];
                }
            }
        }
    }

    int bfs(Puzzle start){

        Queue<Puzzle> que= new ArrayDeque<>();
        que.add(start);
        int count=start.count;
        while (!que.isEmpty()){
            int r=-1,c=-1;
            StringBuilder sb=new StringBuilder();
            boolean tf=true;
            int[][] field = new int[4][4];
            Puzzle q= que.remove();

            for (int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    if(q.p[i][j]!=goal[i][j]){
                        tf=false;
                    }
                    if(q.p[i][j]==0){
                        r = i;
                        c = j;
                    }
                    sb.append(q.p[i][j]);
                    field[i][j]=q.p[i][j];
                }
            }
            count=q.count;
            if(tf){
                break;
            }
            if(mp.get(sb.toString())!=null){
                continue;
            }
            mp.put(sb.toString(), q.count);

            for(int i=0;i<4;i++){
                if(r+dyx[i][0]<0||4<=r+dyx[i][0]||c+dyx[i][1]<0||4<=c+dyx[i][1]) continue;
                int tmp=field[r][c];
                field[r][c]=field[r+dyx[i][0]][c+dyx[i][1]];
                field[r+dyx[i][0]][c+dyx[i][1]]=tmp;
                que.add(new Puzzle(field,q.count+1));
                tmp=field[r][c];
                field[r][c]=field[r+dyx[i][0]][c+dyx[i][1]];
                field[r+dyx[i][0]][c+dyx[i][1]]=tmp;

            }

        }
        return count;

    }




    private void run() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            for (int  j = 0; j < 4;j++){
                goal[i][j]=sc.nextInt();
                start[i][j]=i*4+j+1!=16?i*4+j+1:0;
            }
        }
        System.out.println(bfs(new Puzzle(start,0)));

    }

}
