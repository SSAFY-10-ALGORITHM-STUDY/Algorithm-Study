import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int N = Integer.parseInt(in.readLine());

		int arr[] = new int[N + 1];
		int length[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}

		// i->j로 옮길때 최소값
		for (int i = 1; i <= N; i++) {
			length[i] = 1;
			for (int j = 1; j <= i; j++) {
				if (arr[j] < arr[i]) {
					length[i] = Math.max(length[i], length[j] + 1);
				}
			}
		}

		int maxCnt = 0;
		for (int i = 1; i <= N; i++) {
			maxCnt = Math.max(maxCnt, length[i]);
		}

		System.out.println(N - maxCnt);
	}
}
