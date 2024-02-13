가장 짧은 문자열을 먼저 만들어준 뒤 규칙적으로 늘려가면서 해결



--------------------코드-----------------

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char target[];
	static StringBuilder resultString = new StringBuilder();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		String str = "";

		while ((str = reader.readLine()) != null) {
			N = Integer.parseInt(str);
			resultString.append("-");
			while (resultString.length() < (int) Math.pow(3, N)) {
				String tmp = resultString.toString();
				for (int i = 0; i < tmp.length(); i++) {
					resultString.append(" ");
				}
				resultString.append(tmp);
				tmp = resultString.toString();
			}
			System.out.println(resultString);
			resultString = new StringBuilder();
		}
	}

}
