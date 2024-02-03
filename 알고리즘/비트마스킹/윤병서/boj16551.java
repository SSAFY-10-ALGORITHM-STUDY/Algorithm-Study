/*

비트마스킹을 통한 완전탐색

*/

package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15661 {
	
	static int n;
	static int[][] arr;
	static int ans = 1000000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		
		arr = new int[n][n];
		
		StringTokenizer st;
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0 ; j < n ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		foo(0, 0);
		System.out.println(ans);
	}

	private static void foo(int cnt, int bit) {
		if(cnt == n) {
			int startSum = 0, linkSum = 0;
			List<Integer> startList = new ArrayList<>();
			List<Integer> linkList = new ArrayList<>();
			
			for(int i = 0 ; i < n ; i ++) {
				int chk = (1 << i);
				if((bit & chk) == chk) startList.add(i);
				else linkList.add(i);
			}
			
			for(int i = 0 ; i < startList.size(); i ++) {
				startList.get(i);
				for(int j = i + 1; j < startList.size(); j ++) {
					startSum += arr[startList.get(i)][startList.get(j)] + arr[startList.get(j)][startList.get(i)];
				}
			}
			
			for(int i = 0 ; i < linkList.size(); i ++) {
				for(int j = i + 1; j < linkList.size(); j ++) {
					linkSum += arr[linkList.get(i)][linkList.get(j)] + arr[linkList.get(j)][linkList.get(i)];
				}
			}
			
			ans = Math.min(ans, Math.abs(startSum - linkSum));
			return;
		}
		
		foo(cnt + 1, bit);
		foo(cnt + 1, bit | (1 << cnt));
	}
}
