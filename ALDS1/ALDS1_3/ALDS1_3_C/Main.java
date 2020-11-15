/*
 *  ALDS1_3_3:Doubly Linked List
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_3_C
 */

package ALDS1.ALDS1_3.ALDS1_3_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		DoublyLinkedList list= new DoublyLinkedList();
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			if (line[0].equals("insert")) {
				list.insert(parseInt(line[1]));
			} else if (line[0].equals("delete")) {
				list.delete(parseInt(line[1]));
			} else if (line[0].equals("deleteFirst")) {
			  list.deleteFirst();
			} else {
				list.deleteLast();
			}
		}

		String ans= list.toString();
		System.out.print(ans);


	}

	static String toString(Node tail) {
		StringBuilder sb = new StringBuilder();
		for ( Node node = tail; node != null; node = node.prevNode) {
			sb.append(node.value);
			sb.append(' ');
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append('\n');
		return sb.toString();
	}

}

class Node {
	int value;
	Node prevNode;
	Node nextNode;

	Node(int arg) {
		this.value = arg;
	}

}

class DoublyLinkedList{
	Node head;
	DoublyLinkedList(){
		head=new Node(-1);
		head.prevNode=head;
		head.nextNode=head;
	}
	void insert(int value){
		Node node=new Node(value);
		node.nextNode=head.nextNode;
		node.prevNode=head;
		node.nextNode.prevNode=node;
		head.nextNode=node;
	}
	void delete(int value){
		for(Node n=head.nextNode;n!=head;n=n.nextNode){
			if(n.value==value){
				n.prevNode.nextNode=n.nextNode;
				n.nextNode.prevNode=n.prevNode;
				break;
			}
		}
	}
	void deleteFirst(){
		Node tmp=head.nextNode;
		head.nextNode=tmp.nextNode;
		tmp.nextNode.prevNode=head;
	}
	void deleteLast(){
		Node tmp=head.prevNode;
		tmp.prevNode.nextNode=head;
		head.prevNode=tmp.prevNode;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for ( Node node = head.nextNode; node != head; node = node.nextNode) {
			sb.append(node.value);
			sb.append(' ');
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append('\n');
		return sb.toString();
	}
}