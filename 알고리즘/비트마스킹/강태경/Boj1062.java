package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k, answer;
	static int maxK = 21;
	static int[] bitArr;
	static String eng = "bdefghjklmopqrsuvwxyz";

	static void match(int num) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if ((bitArr[i] & num) == bitArr[i])
				count += 1;
		}
		answer = Math.max(answer, count);
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		bitArr = new int[n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			int bitNum = 0;
			for (int j = 0; j < str.length(); j++) {
				char a = str.charAt(j);
				if(a!='a'&&a!='n'&&a!='t'&&a!='i'&&a!='c')
				bitNum |= (1 << (str.charAt(j) - 'a'));
			}
			bitArr[i] = bitNum;
		}
		answer = 0;
		if (k >= 5) {
			k-=5;
			for(int i = 0; i<(1<<maxK); i++) {
				int count = 0;
				int num = 0;
				for(int j=0; j<maxK; j++) {
					if((i&(1<<j))!=0) {
						count+=1;
						num|=(1<<((eng.charAt(j)-'a')));
					}
				}
				if(count==k) match(num);
			}
		}
		sb.append(answer);

		System.out.println(sb);
	}
}
