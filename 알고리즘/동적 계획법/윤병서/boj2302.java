package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj2302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		int m = Integer.parseInt(in.readLine());
		int dp[] = new int[41];
		dp[0] = 1;
		for (int i = 1; i < 41; i++) {
			if (i <= 3)
				dp[i] = i;
			else
				dp[i] = dp[i - 1] + dp[i - 2];
		}
		int arr[] = new int[n + 1];
		List<Integer> list = new ArrayList<>();
		List<Integer> vip = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int v = Integer.parseInt(in.readLine());
			arr[v] = i;
			if(list.size() == 0) {
				list.add(v - 1);
				vip.add(v);
			}
			else {
				list.add(v - vip.get(list.size() - 1) - 1);
				vip.add(v);
			}
		}
		if(vip.size() == 0) {
			list.add(n);
		}
		else list.add(n - vip.get(list.size() - 1));
		int ans = 1;
		for(int i = 0 ; i < list.size(); i ++) {
			ans *= dp[list.get(i)];
		}
		System.out.println(ans);
	}
}
