import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1253 {

	static int[] arr;
	static int num = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++) {
			int left =0;
			int right = n-1;
			while(true) {
				if(i == left) left++;
				else if(i == right) right--;
				if(left>=right) break;
				
				if(arr[left] + arr[right] ==arr[i]) {
					num++;
					break;
				}
				else if(arr[left] + arr[right] <arr[i]) {
					left++;
				}else if(arr[left] + arr[right] >arr[i]) {
					right--;
				}
			}
		}
		System.out.println(num);
	}

}
