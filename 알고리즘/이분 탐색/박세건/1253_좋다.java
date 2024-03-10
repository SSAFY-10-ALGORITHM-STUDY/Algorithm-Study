N의 범위를 보고 N^3 풀이는 시간초과가 발생한다는 것을 확인
투포인터 방식을 사용해서 만들어질 수 있는 수 인지 확인
반례를 확인해서 만들어 질 수 있는 다른 경우를 확인


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int arr[];
	static int answer;

	static StringBuilder answerString = new StringBuilder();
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		setting();
		Arrays.sort(arr);
		for (int i = 0; i < N; i++) {
			if (isMake1(i) == true || isMake2(i) == true || isMake3(i)) {
				answer++;
			}
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(answer);
	}

	private static boolean isMake2(int idx) {
		int target = arr[idx];
		int start;
		if (idx - 1 >= 0) {
			start = idx - 1;
		} else {
			return false;
		}
		int end;
		if (idx + 1 < N) {
			end = idx + 1;
		} else {
			return false;
		}
		while (start >= 0 && end < N) {
			if (arr[start] + arr[end] > target) {
				start--;
			} else if (arr[start] + arr[end] < target) {
				end++;
			} else {
				return true;
			}
		}
		return false;
	}

	private static boolean isMake1(int idx) {
		int target = arr[idx];
		int start = 0;
		int end = idx - 1;
		while (start < end) {
			if (arr[start] + arr[end] < target) {
				start++;
			} else if (arr[start] + arr[end] > target) {
				end--;
			} else {
				return true;
			}
		}
		return false;
	}

	private static boolean isMake3(int idx) {
		int target = arr[idx];
		int start = idx + 1;
		int end = N - 1;
		while (start < end) {
			if (arr[start] + arr[end] < target) {
				start++;
			} else if (arr[start] + arr[end] > target) {
				end--;
			} else {
				return true;
			}
		}
		return false;
	}

	private static void setting() throws IOException {
		N = Integer.parseInt(reader.readLine());
		arr = new int[N];
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
	}

}
