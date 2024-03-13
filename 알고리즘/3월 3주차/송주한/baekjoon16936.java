package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon16936 {

	static class point implements Comparable<point>{
		long a;
		long b;
		public point(long a, long b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(point o) {
			if(this.b == o.b) {
				return Long.compare(this.a, o.a);
			}
			return Long.compare(o.b, this.b);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		point[] p = new point[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			long a = Long.parseLong(st.nextToken());
			long t =a;
			long b =0;
			while(t%3 ==0) {
				b++;
				t = t/3;
			}
			p[i] = new point(a, b);
		}
		Arrays.sort(p);
		for(int i=0;i<n;i++) {
			sb.append(p[i].a).append(" ");
		}
		System.out.println(sb);
		
	}
}
