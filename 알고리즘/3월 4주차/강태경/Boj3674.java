package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Boj3674 {
	
	static boolean isPrime(int num) {
		if(num==0||num==1) return false;
		if(num==2) return true;
		for(int i=2; i<=Math.sqrt(num);i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	static void permutation(int depth) {
		if(depth<=goalDepth) {
			if(isPrime(num)) set.add(num);
			if(depth==goalDepth) return;
		}
		for(int i=0; i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				num*=10;
				num+=s.charAt(i)-'0';
				permutation(depth+1);
				visit[i]=false;
				num/=10;
			}
		}
	}
	
	static String s;
	static int n, num, goalDepth;
	static boolean[] visit;
	static Set<Integer> set;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			s = br.readLine();
			n = s.length();
			visit = new boolean[n];
			goalDepth = n;
			num = 0;
			set = new TreeSet<>();
			permutation(0);
			sb.append(set.size()).append("\n");
		}
		System.out.println(sb);
		
	}
}