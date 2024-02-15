Moo 수열은 "moo"로 시작
  S(0) = "moo"
  S(1) = "moomooomoo"
  의 규칙에서 S(K) = S(K-1) + m + o*(K+2)개 + S(K-1)의 규칙을 찾음
  찾고자 하는 수열에서 수열의 크기를 분할하면서 답을 탐색



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer> lengthList = new ArrayList<Integer>();
	static char answer;
	static StringBuilder resultString = new StringBuilder();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		setting();
		// int idx = findCorrectIdx();
		findValue(lengthList.size() - 1);
		System.out.println(answer);
	}

	private static int findCorrectIdx() {
		for (int i = 0; i < lengthList.size(); i++) {
			return i;
		}
		return -1;
	}

	private static void findValue(int idx) {
		if (idx == 0) {
			if (N == 1)
				answer = 'm';
			else if (N == 2)
				answer = 'o';
			else if (N == 3)
				answer = 'o';
			return;
		}
		if (N <= lengthList.get(idx - 1)) {
			findValue(idx - 1);
		} else if (N == lengthList.get(idx - 1) + 1) {
			answer = 'm';
			return;
		} else if (N >= lengthList.get(idx - 1) + 2 && N <= lengthList.get(idx - 1) + idx + 3) {
			answer = 'o';
			return;
		} else {
			N -= (lengthList.get(idx - 1) + idx + 3);
			findValue(idx - 1);
		}
	}

	private static void setting() throws IOException {
		N = Integer.parseInt(reader.readLine());
		int len = 3;
		int cnt = 0;
		while (len <= 2_000_000_000) {
			lengthList.add(len);
			cnt++;
			len = len * 2 + 3 + cnt;
		}
	}

}
