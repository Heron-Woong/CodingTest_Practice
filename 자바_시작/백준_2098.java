import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2098 {
    private static final int INF = 1000000*16 +1;
    static int dp[][];
    static int n;
    static int w[][];
    public static void main(String []args) throws IOException {
        BufferedReader  buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[16][1<<16];
        w = new int[16][16];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j = 0; j<n; ++j){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0,1));
    }
    static int tsp(int c, int v){
        if(v == (1<<n) -1){
            return w[c][0] == 0 ? INF : w[c][0];
        }
        if(dp[c][v] != 0){
            return dp[c][v];
        }
        dp[c][v] = INF;
        for(int i =0; i<n; ++i){
            if((v&(1 << i)) == 0 && w[c][i] != 0){
                dp[c][v] = Math.min(dp[c][v], tsp(i, (v | (1 << i))) + w[c][i]);
            }
        }
        return dp[c][v];
    }
}
