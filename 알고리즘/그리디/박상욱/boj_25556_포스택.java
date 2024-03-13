package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[];
	static int answer;

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer token;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();

		int max1 = 0;
		int max2 = 0;
		int max3 = 0;
		int max4 = 0;
		max1 = arr[0];
		for (int i = 1; i < N; i++) {
			if (max1 > arr[i]) {
				if (max2 > arr[i]) {
					if (max3 > arr[i]) {
						if (max4 > arr[i]) {
							System.out.println("NO");
							return;
						} else {
							max4 = arr[i];
						}
					} else {
						max3 = arr[i];
					}
				} else {
					max2 = arr[i];
				}
			} else {
				max1 = arr[i];
			}

		}
		System.out.println("YES");

	}

	private static void input() throws IOException {
		N = Integer.parseInt(reader.readLine());
		arr = new int[N];
		token = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
	}
}
