참조형 클래스는 
equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  equals() 사용해라
  

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static long N;
	static long K, Q;
	static List<Long> aParents;
	static List<Long> bParents;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder answerString = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		// K가 고정되어있기때문에 캐싱할 수 있는 방법 생각해보기
		for (long i = 0; i < Q; i++) {
			// 1은 따로 예외처리해주기
			st = new StringTokenizer(br.readLine());
			long a, b;
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			if (K == 1) {
				System.out.println(Math.abs(a - b));
			} else {
				aParents = getParents(a);
				bParents = getParents(b);
//				System.out.println(aParents);
//				System.out.println(bParents);
				System.out.println(getAnswer(aParents, bParents));
				aParents.clear();
				bParents.clear();
			}
		}
	}

	private static long getAnswer(List<Long> aParents, List<Long> bParents) {
		int answer = 0;
		int aIdx = 0, bIdx = 0;
		while (!aParents.get(aIdx).equals(bParents.get(bIdx))) {
			if (aParents.get(aIdx) > bParents.get(bIdx)) {
				aIdx++;
			} else {
				bIdx++;
			}
			answer++;
		}
		return answer;
	}

	private static List<Long> getParents(long a) {
		List<Long> parents = new ArrayList<>();
		while (a != 1) {
			parents.add(a);
			a = (a - 2) / K + 1;
		}
		parents.add(a);
		return parents;
	}

}
