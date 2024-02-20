import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> list = new ArrayList<>();
		int answer = 1;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			stk.nextToken();
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			List<Integer> pair = new ArrayList<>(Arrays.asList(start, end));
			list.add(pair);
		}

		Collections.sort(list, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				if (o1.get(0) == o2.get(0))
					return o2.get(1) - o1.get(1);
				return o1.get(0) - o2.get(0);
			}
		});
		PriorityQueue<Integer> endList = new PriorityQueue<>();
		endList.add(0);
		for (int i = 0; i < n; i++) {
			while (!endList.isEmpty() && list.get(i).get(0) >= endList.peek()) {
				endList.remove();
			}
			endList.add(list.get(i).get(1));
			answer = Math.max(answer, endList.size());
		}

		sb.append(answer);
		System.out.println(sb);
	}
}
