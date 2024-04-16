이미 찾았던 소수를 확인하는 과정 - 이 과정에서 메모리초과가 계속해서 발생 이미찾았던 소수를 관리하는 데에 최적화를 생각
소수를 판별하는 과정 - 범위를 제곱근으로 축소하여 최적화

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Test {

    static final int MAX_NUMBER = 10000001;
    static final int MAX_SIZE = 7;
    static int N;
    static int answer;
    static char[] arr = new char[MAX_SIZE];
    static Set<Integer> primeNumbers = new HashSet<>();
    static boolean[] visited = new boolean[MAX_SIZE];
    static Set<Integer> set = new HashSet<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
//        findPrimeNumbers();
        N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            String piece = reader.readLine();
            answer = 0;
            makeNumber(piece);
            System.out.println(answer);
        }
    }

    private static void makeNumber(String piece) {
        combinePiece(0, "", piece);
        set.clear();
    }

    private static void combinePiece(int cnt, String cur, String piece) {
        if (cnt > 0) {
            int number = Integer.parseInt(cur);
            if (!set.contains(number) && isPrime(number)) {
//                    System.out.println(number);
                set.add(number);
                answer++;
            }
        }
        if (cnt == piece.length()) {
            return;
        }
        for (int i = 0; i < piece.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                combinePiece(cnt + 1, cur + piece.charAt(i), piece);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

//    private static void findPrime() {
//        for (int i = 2; i < MAX_NUMBER; i++) {
//            if (isNaturalNum[i] == true) {
//                continue;
//            }
//            isNaturalNum[i] = false;
//            if ((long) i * i >= MAX_NUMBER) {
//                continue;
//            }
//            for (int j = i * i; j < MAX_NUMBER; j += i) {
//                isNaturalNum[j] = true;
//            }
//        }
//    }

}
