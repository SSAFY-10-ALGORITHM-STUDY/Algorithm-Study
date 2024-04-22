import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2631 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] d = new int[n];
		int count = 0;
		Arrays.fill(d, 1);
		for(int i=1; i<n;i++){
			for(int j=0; j<i;j++){
				if(arr[i]>arr[j]){
					d[i] = Math.max(d[i], d[j]+1);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			count = Math.max(count, d[i]);
		}
		sb.append(n- count);
		System.out.println(sb);

	}
}