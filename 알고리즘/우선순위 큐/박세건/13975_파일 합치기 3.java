우선순위큐를 이용해서 가장 작은 값 두개의 합을 이용해서 가장 작은 합을 구하는 방식을 사용

-------------코드-------------


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int T, N;
	static int arr[];
	static PriorityQueue<Long> pq;

	static StringBuilder resultString = new StringBuilder();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(reader.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(reader.readLine());
			pq = new PriorityQueue<>();
			long sum = 0;
			tokenizer = new StringTokenizer(reader.readLine());
			for (int i = 0; i < N; i++) {
				pq.add((long) Integer.parseInt(tokenizer.nextToken()));
			}
			while (pq.size() > 1) {
				long a = pq.poll();
				long b = pq.poll();
				pq.add(a + b);
				sum += a + b;
			}
			System.out.println(sum);
		}
	}

}
