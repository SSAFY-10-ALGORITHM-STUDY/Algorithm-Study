import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2302 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] d = new int[n+1];
		boolean[] isVip = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			isVip[Integer.parseInt(br.readLine())]=true;
		}
		d[0]=1;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			if(isVip[i]||isVip[i-1]) d[i] = d[i-1];
			else d[i]= d[i-1]+d[i-2];
		}
		sb.append(d[n]);
		System.out.println(sb);

	}
}