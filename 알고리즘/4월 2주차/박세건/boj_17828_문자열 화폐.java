뒤에서 부터 가장 큰 문자부터 넣을 수 있는지를 확인하면서 진행


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

    static int N, X;
    static StringBuilder answer = new StringBuilder();

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        X = Integer.parseInt(tokenizer.nextToken());
        findString(N, X);
        System.out.println(answer.reverse().toString());
    }

    private static void findString(int size, int stringVal) {
        if (size == 0) {
            if (stringVal != 0) {
                answer = new StringBuilder("!");
            }
            return;
        }
        if (stringVal >= size - 1 + 26) {
            answer.append("Z");
            findString(size - 1, stringVal - 26);
        } else {
            if (stringVal < size) {
                answer = new StringBuilder("!");
            } else {
                answer.append((char) ('A' + (stringVal - size)));
                findString(size - 1, stringVal - (stringVal - size + 1));
            }
        }
    }
}
