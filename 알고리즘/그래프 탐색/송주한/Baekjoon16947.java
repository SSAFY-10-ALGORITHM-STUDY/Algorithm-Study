package S0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon16947 {

	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> arr2 = new ArrayList<>();
	static int[][] station;
	static boolean[] check;
	static int num = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		ArrayList<Integer> subway[] = new ArrayList[n + 1];
		check = new boolean[n + 1];
		station = new int[n + 1][2];
		for (int i = 1; i <= n; i++) {
			subway[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			Integer a = Integer.parseInt(st.nextToken());
			Integer b = Integer.parseInt(st.nextToken());
			subway[a].add(b);
			subway[b].add(a);
		}
		check = new boolean[n + 1];
		arr.add(1);
		check[1] = true;
		dfs(1, 1, 1, n, subway);

		System.out.println(sb);
	}

	private static void cycle(int n, ArrayList<Integer>[] subway) {
		int[] ans = new int[n + 1];
		for (int i = 0; i < arr.size(); i++) {
			ans[arr.get(i)] = -1;
		}
		for (int i = 1; i <= n; i++) {
			if (ans[i] == -1) {
				sb.append("0 ");
				continue;
			}
			arr2.add(i);
			dfs2(i, i, 1, n, subway);
			arr2.clear();
			num = 0;
		}

	}

	private static void dfs2(int a, int prev, int cnt, int n, ArrayList<Integer>[] subway) {
		if (num == -1)
			return;

		for (int i = 0; i < subway[a].size(); i++) {
			int b = subway[a].get(i);
			if (check[b] && prev != b) {
				sb.append(cnt).append(" ");
				num = -1;
				return;
			}

			if (prev != b) {
				check[b] = true;
				arr2.add(b);
				dfs2(b, a, cnt + 1, n, subway);
				check[b] = false;
				arr2.remove(arr2.size() - 1);
			}
		}

	}

	private static void dfs(int a, int prev, int cnt, int n, ArrayList<Integer>[] subway) {
		if (num == 0)
			return;
		for (int i = 0; i < subway[a].size(); i++) {
			int b = subway[a].get(i);
			if (check[b] && prev != b) {
				while (true) {
					if (b != arr.get(0)) {
						check[arr.get(0)] = false;
						arr.remove(0);
						continue;
					}
					break;
				}
				num = 0;
				cycle(n, subway);
				return;
			}

			if (prev != b) {
				check[b] = true;
				arr.add(b);
				dfs(b, a, cnt + 1, n, subway);
				check[b] = false;
				if (arr.size() == 0)
					return;
				arr.remove(arr.size() - 1);
			}
		}

	}

}
