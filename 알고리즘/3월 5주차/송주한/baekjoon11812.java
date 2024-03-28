package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11812 {

	static long num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		while (q-- > 0) {
			st = new StringTokenizer(in.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			if (k == 1) {
				sb.append(Math.abs(x - y)).append("\n");
			} else {
				long[][] arr = new long[2][2];
				arr[0][0] = -1;
				arr[1][0] = -1;
				long d = 0;
				for (long i = 0; i <= N; i++) {
					d += Math.pow(k, i);
					if (arr[0][0] == -1 && x <= d) {
						arr[0][0] = i;
						arr[0][1] = (long) (x - (d - Math.pow(k, i)) - 1);
					}
					if (arr[1][0] == -1 && y <= d) {
						arr[1][0] = i;
						arr[1][1] = (long) (y - (d - Math.pow(k, i)) - 1);
					}
					if (arr[0][0] != -1 && arr[1][0] != -1) {
						break;
					}
				}
				meet(k, arr, 0);
				sb.append(num).append("\n");
				num = 0;
			}
		}
		System.out.println(sb);
	}

	private static void meet(int k, long[][] arr, long cnt) {
		if (arr[0][0] == arr[1][0] && arr[0][1] == arr[1][1]) {
			num = cnt;
			return;
		}

		if (arr[0][0] == arr[1][0]) {
			arr[0][0]--;
			arr[1][0]--;
			arr[0][1] = arr[0][1] / k;
			arr[1][1] = arr[1][1] / k;
			meet(k, arr, cnt + 2);
		} else if (arr[0][0] > arr[1][0]) {
			arr[0][0]--;
			arr[0][1] = arr[0][1] / k;
			meet(k, arr, cnt + 1);
		} else if (arr[0][0] < arr[1][0]) {
			arr[1][0]--;
			arr[1][1] = arr[1][1] / k;
			meet(k, arr, cnt + 1);
		}
	}
}
