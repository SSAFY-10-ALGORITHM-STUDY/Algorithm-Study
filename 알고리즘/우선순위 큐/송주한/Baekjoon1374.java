package S0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Room implements Comparable<Room> {
	int num;
	int start;
	int end;

	public Room(int num, int start, int end) {
		this.num = num;
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Room o) {
		if (this.start == o.start) {
			return this.end - o.end;
		}
		return this.start - o.start;
	}

}

public class Baekjoon1374 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Room> list = new ArrayList<>();
		Stack<Room> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Room(num, start, end));
		}
		Collections.sort(list);
		int max =1;
		for(int i=0;i<n;i++) {
			while(!pq.isEmpty() && pq.peek() <=list.get(i).start) {
				pq.poll();
			}
			pq.add(list.get(i).end);
			max = Math.max(max, pq.size());
		}
		System.out.println(max);
	}
}
