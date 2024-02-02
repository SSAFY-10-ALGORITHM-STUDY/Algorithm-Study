import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int num, k;
	static int[] bd;
	static int tmp;
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(in.readLine());
		num = (int) Math.pow(2, k) - 1;
		bd = new int[num];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < k; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < num; i++) {
			bd[i] = Integer.parseInt(st.nextToken());
		}

		foo(0, num - 1, 0);
		for (int i = 0; i < k; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < list.get(i).size(); j++) {
				sb.append(list.get(i).get(j) + " ");
			}
			System.out.println(sb.toString());
		}
	}

	private static void foo(int st, int ed, int h) {

		if (h == k)
			return;

		int md = (st + ed) / 2;
		list.get(h).add(bd[md]);

		foo(st, md - 1, h + 1);
		foo(md + 1, ed, h + 1);
	}

}
