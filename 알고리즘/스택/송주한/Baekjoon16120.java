package S0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon16120 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		String str = in.readLine();
		boolean check = true;
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			if (str.charAt(i) == 'A') {
				if ((i + 1) < str.length() && str.charAt(i + 1) == 'P' && stack.size() >= 3) {
					stack.pop();
					stack.pop();
					stack.pop();
				} else {
					System.out.println("NP");
					check = false;
					break;
				}
			}
		}
		if (check && stack.size() == 1) {
			System.out.println("PPAP");
		} else if (check) {
			System.out.println("NP");
		}

	}
}