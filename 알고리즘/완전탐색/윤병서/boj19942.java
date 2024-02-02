import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, ans = 100000;
	static int[] m;
	static int[] tmp = {0,0,0,0,0};
	static int[][] arr;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> ansList = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		solution();
	}
    
	public static void solution() throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		for(int i = 0 ; i < n ; i ++){
			list.add(0);
			ansList.add(0);
		}

		m = new int[4];
		st = new StringTokenizer(in.readLine());

		for (int k = 0; k < 4; k++) {
			m[k] = Integer.parseInt(st.nextToken());
		}

		arr = new int[n][5];
		for(int i = 0; i < n ; i ++){
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < 5; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		foo(0, tmp, list);
		if(ans == 100000){
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
		for(Integer it : ansList){
			System.out.print(it + " ");
		}
	}

	public static void foo(int idx, int[] tmp, List<Integer> list){
		boolean check = true;
		for(int i = 0 ; i < 4; i ++){
			if(tmp[i] < m[i]) check = false;
		}

		if(check && ans >= tmp[4]){
			ans = tmp[4];
			ansList = new ArrayList<>();
			for(int i = 0 ; i < n ; i ++){
				if(list.get(i) == 1) ansList.add(i + 1);
			}
			return;
		}

		if(idx >= n || tmp[4] > ans) return;

		foo(idx + 1, tmp, list);
		
        for(int i = 0 ; i < 5; i ++){
			tmp[i] += arr[idx][i];
		}
		list.set(idx, 1);
		foo(idx + 1, tmp, list);
		for(int i = 0 ; i < 5; i ++){
			tmp[i] -= arr[idx][i];
		}
		
        list.set(idx, 0);
	}
}
