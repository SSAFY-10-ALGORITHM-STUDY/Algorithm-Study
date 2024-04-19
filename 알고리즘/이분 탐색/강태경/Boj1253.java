import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1253 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(stk.nextToken()));
		}

		Collections.sort(list);
		int count = 0;
		for (int i = 0; i < n; i++) {
			int start = 0;
			if(i==0) start=1;
			int end = n-1;
			if(i==n-1) end=n-2;
 			int now = list.get(i);
			while(start<end){
				int sum =list.get(start)+list.get(end);
				if(sum<now){
					start++;
					if(start==i) start++;
				} else if(sum>now){
					end--;
					if(end==i) end--;
				} else{
					count++;
					break;
				}

			}
		}
		sb.append(count);
		System.out.println(sb);
	}
}