package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj9934 {
	
	static int[] tree;
	static StringTokenizer stk;
	static int size;
	static void inOrder(int num) {
		if(num>size) return;
		inOrder(num*2);
		tree[num] = Integer.parseInt(stk.nextToken());
		inOrder(num*2+1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		size = (int) Math.pow(2, k)-1;
		tree = new int[size+1];
		inOrder(1);
		int count = 1;
		int index = 1;
		while(count<=size) {
			for(int i=0; i<count; i++) {
				sb.append(tree[index++]).append(" ");
			}
			sb.append("\n");
			count*=2;
		}
		System.out.println(sb);
	}
}
