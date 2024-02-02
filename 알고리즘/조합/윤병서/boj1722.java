/*

dp 배열에 미리 팩토리얼의 값을 저장
팩토리얼 값을 이용해 수열의 순서를 출력

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static long ans, k;
	static long[] dp;
	static int[] arr;
	static boolean[] used;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		solution();
	}
  
	public static void solution() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		n = Integer.parseInt(st.nextToken());

		dp = new long[n + 1];

		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n ; i ++){
			dp[i] = dp[i - 1] * i;
		}

		st = new StringTokenizer(in.readLine());
		m = Integer.parseInt(st.nextToken());
		if(m == 1){
			k = Long.parseLong(st.nextToken());
			k --;
			
			used = new boolean[n + 1];
			for(int i = 1; i <= n ; i ++) {
				list.add(i);
			}
			foo(1);
		} else{
			arr = new int[n + 1];
			used = new boolean[n + 1];
			for(int i = 1 ; i <= n ; i ++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			foo2(1);
			System.out.println(ans + 1);
		}



	}

	private static void foo(int f) {
		if(f == n + 1) return;
		int tmp = 0;
		for(int i = n - f; i >= 0 ; i --){
			if(k - i * dp[n - f] >= 0){
				k -= i * dp[n - f];
				tmp = i;
				break;
			}
		}
		System.out.print(list.get(tmp) + " ");
		list.remove(tmp);

		foo(f + 1);
	}

	private static void foo2(int f) {
		if(f == n + 1) return;
		int cnt = 0;
		for(int i = 1; i < arr[f] ; i ++){
			if(arr[f] > i && used[i] == false) cnt ++;
		}
		used[arr[f]] = true;
		ans += cnt * dp[n - f];
//		System.out.println(cnt * dp[n - f]);
		foo2(f + 1);
	}

}
