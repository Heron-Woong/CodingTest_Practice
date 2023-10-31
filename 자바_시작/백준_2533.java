import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_2533 {
    static ArrayList<Integer> ar[];
    static int dp[][];
    static boolean visited[];
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        StringTokenizer st;
        ar = new ArrayList[n + 1];
        dp = new int[n+1][2];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            ar[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; ++i) {
            st = new StringTokenizer(buf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ar[u].add(v);
            ar[v].add(u);
        }
        DFS(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
    public static void DFS(int start){
        visited[start] = true;
        dp[start][0] = 0;
        dp[start][1] = 1;
        for(int i =0; i<ar[start].size(); ++i){
            int next = ar[start].get(i);
            if(visited[next]) continue;
            DFS(next);
            dp[start][0] += dp[next][1];
            dp[start][1] += Math.min(dp[next][0],dp[next][1]);
        }
    }
}
