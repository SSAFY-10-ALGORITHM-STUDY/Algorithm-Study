package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon25556 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Stack<Integer> s1 = new Stack<>();
		s1.add(0);
		Stack<Integer> s2 = new Stack<>();
		s2.add(0);
		Stack<Integer> s3 = new Stack<>();
		s3.add(0);
		Stack<Integer> s4 = new Stack<>();
		s4.add(0);
		StringTokenizer st = new StringTokenizer(in.readLine());
		boolean ans = true;
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(st.nextToken());
			int[][] check = new int[1][2];
			if(s1.peek()-a<0) {
				check[0][0] = 1;
				check[0][1] = a-s1.peek();
			}
			if(s2.peek()-a<0) {
				if(check[0][0]==0) {
					check[0][0] = 2;
					check[0][1] = a-s2.peek();
				}
				else if(check[0][1] >a-s2.peek()) {
					check[0][0] = 2;
					check[0][1] = a-s2.peek();
				}
			}
			if(s3.peek()-a<0) {
				if(check[0][0]==0) {
					check[0][0] = 3;
					check[0][1] = a-s3.peek();
				}
				else if(check[0][1] >a-s3.peek()) {
					check[0][0] = 3;
					check[0][1] = a-s3.peek();
				}
			}
			if(s4.peek()-a<0) {
				if(check[0][0]==0) {
					check[0][0] = 4;
					check[0][1] = a-s4.peek();
				}
				else if(check[0][1] >a-s4.peek()) {
					check[0][0] = 4;
					check[0][1] = a-s4.peek();
				}
			}
			
			if(check[0][0]==0) {
				ans = false;
				break;
			}else if(check[0][0]==1) {
				s1.add(a);
			}else if(check[0][0]==2) {
				s2.add(a);
			}else if(check[0][0]==3) {
				s3.add(a);
			}else if(check[0][0]==4) {
				s4.add(a);
			}
			
			check[0][0]=0;
			check[0][1]=0;
		}
		
		if(ans) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
