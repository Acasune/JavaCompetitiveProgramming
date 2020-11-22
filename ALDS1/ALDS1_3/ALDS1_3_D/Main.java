/*
 *  ALDS1_3_D: Areas on the Cross-Section Diagram
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/3/ALDS1_3_D
 */

package ALDS1.ALDS1_3.ALDS1_3_D;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String geo=sc.nextLine();
		int n=geo.length(),ans=0;
		Deque<Integer> dq1=new ArrayDeque<>();
		Deque<Tuple> dq2=new ArrayDeque<>();
		for (int i=0;i<n;i++){
			char c=geo.charAt(i);
			if(c=='\\'){
				dq1.push(i);
			}
			if(c=='/'){
				try {
					if(dq1.isEmpty()) continue;
					int l=dq1.pop();
					ans+=i-l;
					int a = i-l;
						while(!dq2.isEmpty()&&dq2.peek().first>l){
							a+=dq2.pop().second;
						}
						dq2.push(new Tuple(l,a));

				}catch (EmptyStackException |NoSuchElementException e){
					continue;
				}
			}

		}
		System.out.println(ans);
		Deque<Integer> ansList=new ArrayDeque<>();
		int kPonds=0;
		while (!dq2.isEmpty()){
			kPonds++;
			ansList.addFirst(dq2.pop().second);
		}
		System.out.print(kPonds);
		while (!ansList.isEmpty()){
			System.out.print(" "+ansList.pop());
		}
		System.out.print("\n");
	}

}
class Tuple{
	int first,second;
	Tuple(int a,int b){
		this.first=a;
		this.second=b;
	}
}
