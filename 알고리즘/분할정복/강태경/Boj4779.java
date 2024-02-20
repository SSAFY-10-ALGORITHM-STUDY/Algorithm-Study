import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[] answer;

	static void cut(int start, int n) {
		if(n==1) return;
		int buf = n/3;
		start+=buf;
		for(int i=start; i<start+buf; i++) {
			answer[i]=' ';
		}
		
		cut(start - buf, buf);
		cut(start+buf, buf);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = "";
		while ((line = br.readLine()) != null&&!line.isEmpty()) {
			int n = (int)Math.pow(3,Integer.parseInt(line));
			answer = new char[n];
			for(int i=0; i<n; i++) answer[i] = '-';
			cut(0, n);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
