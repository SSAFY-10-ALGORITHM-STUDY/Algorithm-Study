package com.ssafy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer> list=new ArrayList<>();
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer=new StringTokenizer(reader.readLine());
		N=Integer.parseInt(tokenizer.nextToken());
		M=Integer.parseInt(tokenizer.nextToken());
		tokenizer=new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(tokenizer.nextToken()));
		}
		StringBuilder builder=new StringBuilder();
		for (int i = 0; i < M; i++) {
			tokenizer=new StringTokenizer(reader.readLine());
			String type=tokenizer.nextToken();
			if(type.equals("BN")) {
				
				int x=Integer.parseInt(tokenizer.nextToken());
				int y=Integer.parseInt(tokenizer.nextToken());
				int idx=list.indexOf(x);
				if(++idx==list.size()) {
					idx=0;
				}
				builder.append(list.get(idx)).append("\n");
				list.add(idx,y);
				//idx는 다음칸의 인덱스 이 칸과 탐색했던 칸 사이에 y대입
			}else if(type.equals("BP")) {
				int x=Integer.parseInt(tokenizer.nextToken());
				int y=Integer.parseInt(tokenizer.nextToken());
				int idx=list.indexOf(x);
				if(idx-1<0) {
					idx=list.size();
				}
				builder.append(list.get(idx-1)).append("\n");
				if(idx==list.size()) {
					idx=0;
				}
				list.add(idx,y);
				//idx는 다음칸의 인덱스 이 칸과 탐색했던 칸 사이에 y대입
			}else if(type.equals("CN")) {
				int x=Integer.parseInt(tokenizer.nextToken());
				int idx=list.indexOf(x);
				if(++idx==list.size()) {
					idx=0;
				}
				builder.append(list.get(idx)).append("\n");
				list.remove(idx);
				//idx는 다음칸의 인덱스 이 칸과 탐색했던 칸 사이에 y대입
			}else if(type.equals("CP")) {
				
				int x=Integer.parseInt(tokenizer.nextToken());
				int idx=list.indexOf(x);
				if(--idx<0) {
					idx=list.size()-1;
				}
				builder.append(list.get(idx)).append("\n");
				list.remove(idx);
			}
			
		}
		 System.out.println(builder);
		
	}

}
