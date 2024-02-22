package S0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon5904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();
		int n = Integer.parseInt(in.readLine());
		int i = 0;
		int max = 0;
		while (true) {
			if (max * 2 + i + 3 > n) {
				System.out.println(moo(n, max, i));
				break;
			}
			max = max * 2 + i + 3;
			i++;
		}
	}

	private static String moo(int n, int max, int i) {
		if (max == 0) {
			if (n == 1) {
				return "m";
			} else {
				return "o";
			}
		}

		while (true) {
			if (n <= max) {
				max = (max - (i - 1) - 3) / 2;
				i--;
			} else if (n <= max + i + 3) {
				if (n == max + 1) {
					return "m";
				} else
					return "o";
			} else {
				n = n - (max + i + 3);
				max = (max - (i - 1) - 3) / 2;
				i--;
			}
			if (max == 0) {
				if (n == 1) {
					return "m";
				} else {
					return "o";
				}
			}
		}
	}
}
