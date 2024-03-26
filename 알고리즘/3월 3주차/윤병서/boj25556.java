package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj25556 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean flag = true;
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();
		Stack<Integer> s4 = new Stack<>();
		s1.add(arr[0]);
		for(int i = 1 ; i < n ; i ++) {
			if(s1.peek() < arr[i]) {
				s1.add(arr[i]);
			}
			else {
				if(s2.size() == 0) {
					s2.add(arr[i]);
				}
				else if(s2.peek() < arr[i]) {
					s2.add(arr[i]);
				}
				else {
					if(s3.size() == 0) {
						s3.add(arr[i]);
					}
					else if(s3.peek() < arr[i]) {
						s3.add(arr[i]);
					}
					else {
						if(s4.size() == 0) {
							s4.add(arr[i]);
						}
						else if(s4.peek() < arr[i]) {
							s4.add(arr[i]);
						}
						else
							flag = false;
					}
				}
			}
			
		}
		if(flag == true)
			System.out.println("YES");
		else System.out.println("NO");
		
	}
}
