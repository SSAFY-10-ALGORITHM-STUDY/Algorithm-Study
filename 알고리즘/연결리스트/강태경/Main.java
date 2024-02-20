package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static Node[] nodes;

	static class Node {

		int value;
		Node prev;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	static class Link {
		Node head;
		Node tail;

		void add(Node node) {
			if (head == null) {
				head = tail = node;
				tail.next = tail;
				tail.prev = tail;
			} else {
				node.prev = tail;
				node.next = head;
				head.prev = node;
				tail.next = node;
				tail = node;
			}
		}

		void bn(int position, int value) {
			Node now = nodes[position];
			Node node = nodes[value];
			sb.append(now.next.value).append("\n");
			node.next = now.next;
			now.next.prev = node;
			now.next = node;
			node.prev = now;
		}

		void bp(int position, int value) {
			Node now = nodes[position];
			Node node = nodes[value];
			sb.append(now.prev.value).append("\n");
			node.prev = now.prev;
			now.prev.next = node;
			now.prev = node;
			node.next = now;
		}

		void cn(int position) {
			Node now = nodes[position];
			sb.append(now.next.value).append("\n");
			now.next = now.next.next;
			now.next.prev = now;
		}

		void cp(int position) {
			Node now = nodes[position];
			sb.append(now.prev.value).append("\n");
			now.prev = now.prev.prev;
			now.prev.next = now;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		nodes = new Node[1_000_001];
		for (int i = 1; i <= 1000000; i++) {
			nodes[i] = new Node(i);
		}

		Link link = new Link();

		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			link.add(nodes[Integer.parseInt(stk.nextToken())]);
		}
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			String code = stk.nextToken();
			int num = Integer.parseInt(stk.nextToken());
			if (code.equals("BN")) {
				int num2 = Integer.parseInt(stk.nextToken());
				link.bn(num, num2);
			} else if (code.equals("BP")) {
				int num2 = Integer.parseInt(stk.nextToken());
				link.bp(num, num2);
			} else if (code.equals("CN")) {
				link.cn(num);
			} else {
				link.cp(num);
			}
		}

		System.out.println(sb);
	}
}