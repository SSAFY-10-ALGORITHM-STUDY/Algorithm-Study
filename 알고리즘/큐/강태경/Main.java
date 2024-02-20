package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		long answer=0;
		int[] name = new int[n+1];
		for(int i=1; i<=n; i++) {
			name[i] = br.readLine().length();
		}
		Deque<Integer> q = new ArrayDeque<>();
		int[] size = new int[21];
		for(int i=1; i<=k; i++) {
			q.add(name[i]);
			size[name[i]]++;
		}
		int index = k+1;
		if(k<n) {
			q.add(name[k+1]);
			size[name[k+1]]++;
			index++;
		}
		while(q.size()>1) {
			int now = q.remove();
			size[now]--;
			answer+=size[now];
			if(index<=n) {
				q.add(name[index]);
				size[name[index]]++;
				index++;
			}
		}

		
		sb.append(answer);
		System.out.println(sb);
	}
}