package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj22856 {
	static class Node {
		int left;
		int right;

		Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static int n;
	static List<Node>[] list;
	static int lastNode;
	static int cnt;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		list = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = (new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
		}

		inOrder(1);
		foo(1);
		System.out.println(ans);
	}

	private static void foo(int cur) {
		Node tmp = list[cur].get(0);
		if (tmp.left != -1) {
			cnt++;
			foo(tmp.left);
		}
		if (tmp.right != -1) {
			cnt++;
			foo(tmp.right);
		}
		if (cur == lastNode) {
			ans = cnt;
			return;
		}
		cnt++;
	}

	private static void inOrder(int cur) {
		Node tmp = list[cur].get(0);
		if (tmp.left != -1)
			inOrder(tmp.left);
		lastNode = cur;
		if (tmp.right != -1)
			inOrder(tmp.right);
	}
}
