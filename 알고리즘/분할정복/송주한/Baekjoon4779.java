package S0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon4779 {

	static int n=0;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input ="";
		
		while((input=in.readLine()) != null && !input.isEmpty()){
			n = Integer.parseInt(input);
			str = new String[(int) Math.pow(3, 13)];
			aggregation(0);
			for(int i=0;i<Math.pow(3, n);i++) {
				sb.append(str[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void aggregation(int cnt) {
		if(n < cnt) {
			return;
		}  
		
		if(cnt ==0) {
			str[0]="-";
		}else {
			for(int i=0;i<Math.pow(3, cnt-1);i++) {
				str[(int) (Math.pow(3, cnt-1)+i)]=" ";
			}
			System.arraycopy(str, 0, str, (int)(Math.pow(3, cnt-1)*2), (int)(Math.pow(3, cnt-1)));
		}
		
		aggregation(cnt+1);
		
	}
	
}
