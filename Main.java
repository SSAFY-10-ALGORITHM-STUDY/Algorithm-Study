import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static StringBuilder sb = new StringBuilder();
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static int N;
	public static int[] moo = new int[1000000];

	// moo[n-1] <L> moo[n] <R> moo[n-1]
	public static void divide(int i, int left, int right) {
		if (i == 0) {
			if(N == left) {
				System.out.println('m');
			}
			else {
				System.out.println('o');
			}
			return;
		}

		// Left moo[i-1]
		if (N < left + moo[i - 1]) {
			divide(i - 1, left, left + moo[i - 1]);
		} // Right moo[i-1]
		else if (N >= left + moo[i - 1] + (i + 3)) {
			divide(i - 1, left + moo[i - 1] + (i + 3), right);
		}
		// 사이에 있는 경우
		else {
			// N이 첫번째 위치라면
			if (N == left + moo[i - 1]) {
				System.out.println('m');
			} else {
				System.out.println('o');
			}
			return;
		}
	}

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(in.readLine());

		moo[0] = 3;
		int i = 0;

		while (moo[i++] < N) {
			moo[i] = moo[i - 1] + (i + 3) + moo[i - 1];
		}
		i--;

		
		divide(i, 1, moo[i]);

	}
}