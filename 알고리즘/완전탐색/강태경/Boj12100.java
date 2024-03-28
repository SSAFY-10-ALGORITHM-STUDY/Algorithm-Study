import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Boj12100 {

    static int n, answer;
    static int[][] map;
    static Deque<int[][]> q;
    static Deque<Integer> buf;
    static void comb(int depth) {
        if (depth == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            save();
            move(i);
            comb(depth + 1);
            load();

        }
    }

    static void save() {
        int[][] buf = new int[n][n];
        for (int i = 0; i < n; i++) {
            buf[i] = map[i].clone();
        }
        q.add(buf);
    }

    static void load() {
        map = q.removeLast();
    }

    static void move(int direct) {
        if (direct == 0) left();
        else if (direct == 1) right();
        else if (direct == 2) up();
        else down();
    }

    static void left() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) buf.add(map[i][j]);
            }
            int first = 0;
            int idx = 0;
            if (!buf.isEmpty()) {
                first = buf.remove();
                if (buf.size() == 0) {
                    map[i][idx++] = first;
                }
            }
            while (!buf.isEmpty()) {
                int second = buf.remove();
                if (first == second) {
                    map[i][idx] = first + second;
                    answer = Math.max(answer, map[i][idx++]);
                    if (buf.size() == 1) {
                        map[i][idx++] = buf.remove();
                    } else if (buf.size() > 1) first = buf.remove();
                } else {
                    map[i][idx++] = first;
                    if (buf.isEmpty()) map[i][idx++] = second;
                    else first = second;
                }
            }
            for (int j = idx; j < n; j++) {
                map[i][j] = 0;
            }
        }
    }

    static void right() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) buf.addFirst(map[i][j]);
            }
            int first = 0;
            int idx = n - 1;
            if (!buf.isEmpty()) {
                first = buf.remove();
                if (buf.size() == 0) {
                    map[i][idx--] = first;
                }
            }
            while (!buf.isEmpty()) {
                int second = buf.remove();
                if (first == second) {
                    map[i][idx] = first + second;
                    answer = Math.max(answer, map[i][idx--]);
                    if (buf.size() == 1) {
                        map[i][idx--] = buf.remove();
                    } else if (buf.size() > 1) first = buf.remove();
                } else {
                    map[i][idx--] = first;
                    if (buf.isEmpty()) map[i][idx--] = second;
                    else first = second;
                }
            }
            for (int j = idx; j >= 0; j--) {
                map[i][j] = 0;
            }
        }
    }

    static void up() {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] != 0) {
                	buf.add(map[i][j]);
                }
            }
            int first = 0;
            int idx = 0;
            if (!buf.isEmpty()) {
                first = buf.remove();
                if (buf.size() == 0) {
                    map[idx++][j] = first;
                }
            }
            while (!buf.isEmpty()) {
                int second = buf.remove();
                if (first == second) {
                    map[idx][j] = first + second;
                    answer = Math.max(answer, map[idx++][j]);
                    if (buf.size() == 1) {
                        map[idx++][j] = buf.remove();
                    } else if (buf.size() > 1) first = buf.remove();
                } else {
                    map[idx++][j] = first;
                    if (buf.isEmpty()) map[idx++][j] = second;
                    else first = second;
                }
            }
            for (int i = idx; i < n; i++) {
                map[i][j] = 0;
            }
        }
    }

    static void down() {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] != 0) buf.addFirst(map[i][j]);
            }
            int first = 0;
            int idx = n - 1;
            if (!buf.isEmpty()) {
                first = buf.remove();
                if (buf.size() == 0) {
                    map[idx--][j] = first;
                }
            }
            while (!buf.isEmpty()) {
                int second = buf.remove();
                if (first == second) {
                    map[idx][j] = first + second;
                    answer = Math.max(answer, map[idx--][j]);
                    if (buf.size() == 1) {
                        map[idx--][j] = buf.remove();
                    } else if (buf.size() > 1) first = buf.remove();
                } else {
                    map[idx--][j] = first;
                    if (buf.isEmpty()) map[idx--][j] = second;
                    else first = second;
                }
            }
            for (int i = idx; i >= 0; i--) {
                map[i][j] = 0;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer = 0;
        q = new ArrayDeque<>();
        buf = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                answer = Math.max(answer, map[i][j]);
            }
        }
        comb(0);
        sb.append(answer);
        System.out.println(sb);
    }
}