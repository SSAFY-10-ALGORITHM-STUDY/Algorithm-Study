package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15661 {
	
	static int n, out, answer;
	static int[][] stat;
	
	static void combination(int depth, int start) {
		if(depth==n) return;
		if(depth>0) {
			int score1 = 0;
			int score2 = 0;
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for(int i=0; i<n;i++) {
				if((out&(1<<i))!=0) {
					list1.add(i);
				}else {
					list2.add(i);
				}
			}
			for(int i=0; i<list1.size();i++) {
				for(int j=i+1;j<list1.size();j++) {
					score1+=stat[list1.get(i)][list1.get(j)];
					score1+=stat[list1.get(j)][list1.get(i)];
				}
			}
			for(int i=0; i<list2.size();i++) {
				for(int j=i+1;j<list2.size();j++) {
					score2+=stat[list2.get(i)][list2.get(j)];
					score2+=stat[list2.get(j)][list2.get(i)];
				}
			}
			answer = Math.min(answer, Math.abs(score1-score2));
			
		}
		for(int i= start; i<n;i++) {
			out|=(1<<i);
			combination(depth+1, i+1);
			out^=(1<<i);
		}
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		stat = new int[n][n];
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				stat[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		out = 0;
		answer = Integer.MAX_VALUE;
		combination(0, 0);
		sb.append(answer);
		System.out.println(sb);
	}
}