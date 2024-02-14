package S0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon13975 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		PriorityQueue<Long> queue = new PriorityQueue<>();
		long a=0;
		long b=0;
		long sum=0;
		long totalSum=0;
		while(T-->0) {
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++) {
				queue.add((long) Integer.parseInt(st.nextToken()));
			}
			totalSum=0;
			while(queue.size()>1) {
				a = queue.poll();
				b  = queue.poll();
				sum =a+b;
				totalSum += sum;
				queue.add(sum);
			}
			queue.poll();
			sb.append(totalSum).append("\n");
		}
		System.out.println(sb);
	}
}

 