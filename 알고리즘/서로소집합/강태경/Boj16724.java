import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16724 {

    static int n, m, count;
    static char[][] graph;
    static boolean[][] visited;

    static void dfs(int x, int y){
        int nx = x;
        int ny = y;
        if(graph[x][y]=='D'){
            nx++;
        } else if(graph[x][y]=='U'){
            nx--;
        } else if(graph[x][y]=='L'){
            ny--;
        } else ny++;
        if(!visited[nx][ny]){
            visited[nx][ny]=true;
            dfs(nx, ny);
        } else{
            if(graph[nx][ny]!='1') {
                count++;
            }
        }
        graph[x][y]='1';
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        count = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j);
                }
            }
        }
        sb.append(count);
        System.out.println(count);
    }
}