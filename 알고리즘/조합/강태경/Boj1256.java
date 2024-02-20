import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[][] d = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            d[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            d[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] = d[i - 1][j] + d[i][j - 1];
                if(d[i][j]>1000000000) d[i][j]=1000000000;
            }
        }
        if(k>d[n][m]) sb.append(-1);
        else {
            while(n!=0&&m!=0) {
                if(d[n-1][m]>=k) {
                    sb.append("a");
                    n--;
                } else {
                    sb.append("z");
                    k-=d[n-1][m];
                    m--;
                }
            }
            while(n-->0) sb.append("a");
            while(m-->0) sb.append("z");
        }


        System.out.println(sb);
    }
}
