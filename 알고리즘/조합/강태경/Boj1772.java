import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long k;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		boolean[] visit = new boolean[n + 1];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(stk.nextToken());
		long[] factArr = new long[n];
		factArr[0] = 1L;
		for (int i = 1; i < n; i++) {
			factArr[i] = i * factArr[i - 1];
		}
		if (num == 1) {
			int[] answer = new int[n + 1];
			k = Long.parseLong(stk.nextToken()) - 1;
			for (int i = 1; i < n; i++) {
				long now = 1L;
				now += k / factArr[n - i];
				k %= factArr[n - i];
				long count = 0L;
				for (int j = 1; j <= n; j++) {
					if (!visit[j]) {
						count += 1L;
						if (count == now) {
							answer[i] = j;
							visit[j] = true;
							break;
						}
					}
				}
			}
			for (int i = 1; i <= n; i++) {
				if (!visit[i]) {
					answer[n] = i;
				}
			}
			for (int i = 1; i <= n; i++) {
				sb.append(answer[i]).append(" ");
			}
			System.out.println(sb);
		} else {
			long answer = 1L;
			arr = new int[n+1];
			visit = new boolean[n+1];
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				int now = arr[i];
				int count = 0;
				for(int j=1; j<=n; j++) {
					if(!visit[j]) {
						count+=1;
						if(now==j) {
							answer+=(count-1)*factArr[n-i];
							visit[j]=true;
						}
					}
				}
				
			}
			sb.append(answer);
			System.out.println(sb);
		}
	}
}
