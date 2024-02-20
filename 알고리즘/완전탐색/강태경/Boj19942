import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] arr;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> list;

	static void combination(int[] arr, boolean[] visit, int start, int n, int r) {
		if (r == 0) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				if (visit[i])
					temp.add(i);
			}
			list.add(temp);
			return;
		}

		for (int i = start; i <= n; i++) {
			visit[i] = true;
			combination(arr, visit, i + 1, n, r - 1);
			visit[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		list = new ArrayList<>();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int mp = Integer.parseInt(stk.nextToken());
		int mf = Integer.parseInt(stk.nextToken());
		int ms = Integer.parseInt(stk.nextToken());
		int mv = Integer.parseInt(stk.nextToken());
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int p = 0, f = 0, s = 0, v = 0, cost = 0;
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine());
			p = Integer.parseInt(stk.nextToken());
			f = Integer.parseInt(stk.nextToken());
			s = Integer.parseInt(stk.nextToken());
			v = Integer.parseInt(stk.nextToken());
			cost = Integer.parseInt(stk.nextToken());
			map.put(i, new ArrayList<>(List.of(cost, p, f, s, v)));
		}
		for (int i = 1; i <= n; i++) {
			visit = new boolean[n + 1];
			combination(arr, visit, 1, n, i);
		}
		ArrayList<ArrayList<Integer>> answer = null;
		ArrayList<Integer> temp = null;
		int lowCost = 10000;
		int np, nf, ns, nv, ncost;
		for (ArrayList<Integer> comb: list) {
			np =nf =ns = nv = ncost =0;
			for (int idx : comb) {
				temp = map.get(idx);
				ncost+=temp.get(0);
				np+=temp.get(1);
				nf+=temp.get(2);
				ns+=temp.get(3);
				nv+=temp.get(4);
			}
			if (np>=mp && nf>=mf && ns>=ms && nv>=mv) {
//				System.out.println(comb);
				if (ncost<lowCost) {
					lowCost = ncost;
					answer = new ArrayList<>();
					answer.add(comb);
				} else if(ncost==lowCost) {
					answer.add(comb);
				}
			}
		}
		if(answer==null) System.out.println(-1);
		else {
			System.out.println(lowCost);
			Collections.sort(answer, new Comparator<ArrayList<Integer>>() {
				@Override
				public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
					for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
						int compareResult = o1.get(i).compareTo(o2.get(i));
						if(compareResult!=0) {
							return compareResult;
						}
					}
					return Integer.compare(o1.size(), o2.size());
				}
			});
			for (int num : answer.get(0)) {
				System.out.print(num+" ");
			}
		}
	}
}
