import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj16936 {

    static class Pair {
        long num;
        long three;

        public Pair(long num, long three) {
            this.num = num;
            this.three = three;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long now = Long.parseLong(stk.nextToken());
            long q = 0;
            long buf = now;
            while(buf%3==0){
                buf/=3;
                q++;
            }
            list.add(new Pair(now, q));
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.three == o2.three) {
                    if(o1.num>o2.num) return 1;
                    else if(o1.num==o2.num) return 0;
                    return -1;
                }
                if(o1.three<o2.three) return 1;
                else if(o1.num==o2.num) return 0;
                return -1;
            }
        });
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i).num).append(" ");
        }
        System.out.println(sb);
    }
}