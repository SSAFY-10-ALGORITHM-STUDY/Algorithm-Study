import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k, ans = 0;
	static int[] arr;

	public static void main(String[] args) throws Exception{
		solution();
	}
  
	public static void solution() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		str = in.readLine();
		st = new StringTokenizer(str, " ");
		arr = new int[k];
		for(int i = 0; i < k ; i ++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		foo(0);
		System.out.println(ans);
	}

	private static void foo(int num) {
		if(n < num) return;
		for(int i = 0 ; i < k; i ++){
            int tmp = num * 10 + arr[i];
			if(ans < tmp && tmp <= n) ans = tmp;
			foo(tmp);
		}
	}
}
