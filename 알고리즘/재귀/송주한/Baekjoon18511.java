package S0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon18511 {

	static StringBuilder sb = new StringBuilder();
	static boolean check = false;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String n = st.nextToken();
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
//		for(int i=0;i<n.length();i++) {
//			ans(n.charAt(i)-'0',arr);
//		}
		ans(n, 0, arr, 0);
		System.out.println(max);
	}

	private static void ans(String n, int cnt, int[] arr, int ans) {
		if (n.length() == cnt) {
			max = Math.max(max, ans);
			return;
		}
		
		if(check) {
			ans(n,cnt+1,arr,ans*10+arr[arr.length - 1]);
		}
		int num = (int)(n.charAt(cnt)-'0');
		for (int i = arr.length - 1; i >= 0; i--) {
			
			if (arr[i] == num) {
				ans(n,cnt+1,arr,ans*10+arr[i]);
			}
			if (arr[i] < num) {
				check =true;
				ans(n,cnt+1,arr,ans*10+arr[i]);
				check = false;
			}
		}
		if(cnt ==1 && ans==0) {
			check = true;
			ans(n,cnt+1,arr,ans*10+arr[arr.length - 1]);
			check = false;
		}
		ans(n,cnt+1,arr,ans);
	}
}