import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<= n ; i ++) {
			q.add(i);
		}
		boolean chk = true;
		while(chk) {
			if(q.size() < k) {
				System.out.println(q.poll());
				chk = false;
			}
			else {
				int tmp = q.poll();
				for(int i = 0 ; i < k - 1; i ++) {
					q.remove();
				}
				q.add(tmp);
			}
		}
	}
}
