package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int answer;
	static int k;
	static int[] arr;
	
	static void solution(int num) {
		if(answer<num) {
			answer = num;
		}
		for(int i =0; i<k; i++) {
			int buf = num*10+arr[i];
			if(buf<=n) solution(buf);
		}
		
	
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		answer = 0;
		arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		for(int i=0; i<k; i++) {
			solution(arr[i]);
		}
		sb.append(answer);
		System.out.println(sb);
	}
}
