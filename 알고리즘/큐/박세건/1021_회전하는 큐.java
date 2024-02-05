링크드 리스트를 직접 구현해서 앞과 뒤에서 삭제와 삽입이 가능한 자료구조를 구현



-------------------코드------------------------


package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static MyLinkedList myLinkedList = new MyLinkedList();
	static int answer;

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;
	static StringBuilder resultString = new StringBuilder();

	public static void main(String[] args) throws IOException {
		tokenizer = new StringTokenizer(reader.readLine());
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		for (int i = 1; i <= N; i++) {
			myLinkedList.addBack(i);
		}
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(tokenizer.nextToken());
			moveForRemove(tmp);
		}
		System.out.println(answer);
	}

	private static void moveForRemove(int tmp) {
		int fromFront = myLinkedList.idxOfValByFront(tmp);
		int fromBack = myLinkedList.idxOfValByBack(tmp) + 1; // 뒤에서 삭제가 아닌 앞에와서 삭제이기에
		if (fromFront < fromBack) {
			answer += fromFront;
			for (int i = 0; i < fromFront; i++) {
				myLinkedList.addBack(myLinkedList.removeFront());
			}
			myLinkedList.removeFront();
		} else if (fromBack < fromFront) {
			answer += fromBack;
			for (int i = 0; i < fromBack; i++) {
				myLinkedList.addFront(myLinkedList.removeBack());
			}
			myLinkedList.removeFront();
		} else {
			answer += fromFront;
			for (int i = 0; i < fromBack; i++) {
				myLinkedList.addFront(myLinkedList.removeBack());
			}
			myLinkedList.removeFront();
		}
	}

}

class MyLinkedList {
	Node head;
	Node tail;

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public void addBack(int val) {
		Node node = new Node(val);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.nextNode = node;
			node.previousNode = tail;
			tail = node;
		}
	}

	public void addFront(int val) {
		Node node = new Node(val);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.nextNode = head;
			head.previousNode = node;
			head = node;
		}
	}

	public Integer removeFront() {
		if (head == null) {
			return null;
		} else if (head.nextNode == null) {
			int val = head.val;
			head = null;
			tail = null;
			return val;
		} else {
			int tmpVal = head.val;
			Node tmp = head.nextNode;
			head = null;
			tmp.previousNode = null;
			head = tmp;
			return tmpVal;
		}
	}

	public Integer removeBack() {
		if (head == null) {
			return null;
		} else if (head.nextNode == null) {
			int val = head.val;
			head = null;
			tail = null;
			return val;
		} else {
			int tmpVal = tail.val;
			Node tmp = tail.previousNode;
			tail = null;
			tmp.nextNode = null;
			tail = tmp;
			return tmpVal;
		}
	}

	public int idxOfValByFront(int val) {
		int idx = 0;
		Node tmpNode = head;
		while (tmpNode.val != val) {
			tmpNode = tmpNode.nextNode;
			idx++;
		}
		return idx;
	}

	public int idxOfValByBack(int val) {
		int idx = 0;
		Node tmpNode = tail;
		while (tmpNode.val != val) {
			tmpNode = tmpNode.previousNode;
			idx++;
		}
		return idx;
	}

	public void printLinkedList() {
		Node tmp = head;
		while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.nextNode;
		}
		System.out.println();
	}

}

class Node {
	int val;
	Node nextNode;
	Node previousNode;

	public Node(int val) {
		this.val = val;
		this.nextNode = null;
		this.previousNode = null;
	}

}
