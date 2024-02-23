Wrapper 클래스는 기본형으로 변환후에 사용하는 것을 습관화하자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static int[] parents;
	static int[] target;

	static StringBuilder answerString = new StringBuilder();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(reader.readLine());
		for (int t = 0; t < T; t++) {
			setting();
			System.out.println(findCommomParent());
		}
	}

	private static int findCommomParent() {
		List<Integer> aParents = new ArrayList<>();
		List<Integer> bParents = new ArrayList<>();
		while (target[0] != 0) {
			aParents.add(target[0]);
			target[0] = parents[target[0]];
		}
		while (target[1] != 0) {
			bParents.add(target[1]);
			target[1] = parents[target[1]];
		}
//		System.out.println(aParents);
//		System.out.println(bParents);
		for (int i = 0; i < aParents.size(); i++) {
			for (int j = 0; j < bParents.size(); j++) {
				if (aParents.get(i).equals(bParents.get(j))) {
					return aParents.get(i);
				}
			}
		}
		return -1;
	}

	private static void setting() throws IOException {

		N = Integer.parseInt(reader.readLine());
		parents = new int[N + 1];
		target = new int[2];
		for (int i = 0; i < N - 1; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			parents[b] = a;
		}
		tokenizer = new StringTokenizer(reader.readLine());
		target[0] = Integer.parseInt(tokenizer.nextToken());
		target[1] = Integer.parseInt(tokenizer.nextToken());
	}

}
