/*

처음에 늑대 처리가 번거로울 것 같아 바텀업으로 구현했지만 시간 초과
탑다운으로 재구현 및 늑대를 -값으로 넣어줘서 따로 처리하지 않고 탐색

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class myPair {
	Integer y;
	Integer x;

	public myPair(Integer y, Integer x) {
		this.y = y;
		this.x = x;
	}

	public Integer first() {
		return y;
	}

	public Integer second() {
		return x;
	}
}

public class Main {
	static List<List<myPair>> list = new ArrayList<>();
	static long ans = 0;
	static int[] sheep;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringTokenizer st = null;

		for (int i = 0; i <= t; i++)
			list.add(new ArrayList<>());

		sheep = new int[t + 1];

		for (int i = 2; i <= t; i++) {
			st = new StringTokenizer(in.readLine());
			String tmp = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if (tmp.equals("W"))
				num *= -1;

			sheep[i] = num;
			int start = Integer.parseInt(st.nextToken());
			list.get(start).add(new myPair(num, i));
		}

		ans = foo(1);

		System.out.println(ans);
	}

	private static long foo(int cur) {
		long tmp = 0;

		for (int i = 0; i < list.get(cur).size(); i++) {
			tmp += foo(list.get(cur).get(i).second());
		}

		tmp += sheep[cur];

		if (tmp < 0)
			tmp = 0;

		return tmp;
	}
}
