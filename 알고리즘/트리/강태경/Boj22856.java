import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static Node[] nodes;
	static int count = 0;

	static class Node {

		int left;
		int right;

		Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static class Tree {

		void newInorder(Node node, int flag) {
			if (node.left != -1) {
				count += 2;
				newInorder(nodes[node.left], 1);
			}
			if (flag == 1) {
				if (node.right != -1) {
					count += 2;
					newInorder(nodes[node.right], 1);
				}
			} else {
				if (node.right != -1) {
					count++;
					newInorder(nodes[node.right], 0);
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		nodes = new Node[n + 1];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(stk.nextToken());
			int left = Integer.parseInt(stk.nextToken());
			int right = Integer.parseInt(stk.nextToken());
			nodes[num] = new Node(left, right);
		}
		// flag: 1이면 모든 경로 2
		Tree tree = new Tree();
		tree.newInorder(nodes[1], 0);
		sb.append(count);
		System.out.println(sb);
	}
}
