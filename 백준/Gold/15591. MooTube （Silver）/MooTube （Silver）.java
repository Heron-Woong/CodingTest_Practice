import java.util.*;
import java.io.*;

public class Main {
    public static class Node{
        int u,k;
        public Node(int u, int k){
            this.u = u;
            this.k = k;
        }
    }
    static int n;
    static ArrayList<Node> arr[];
    static boolean visited[];
    static int dp[][] = new int[n+1][];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        dp = new int[n+1][n+1];
        for(int i = 1; i <= n; ++i){
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                dp[i][j] = (int)1e9;
            }
        }

        for(int i = 0; i < n-1; ++i){
            st = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
            dp[a][b] = c;
            dp[b][a] = c;
        }
        for(int i = 1; i <= n; ++i){
            visited = new boolean[n+1];
            dfs(i,i);
        }
        for(int i = 0; i < q; ++i){
            st = new StringTokenizer(buf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j = 1; j <= n; ++j){
                if(dp[b][j] == (int)1e9)continue;
                if(dp[b][j] >= a) ++cnt;
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int start, int now){
        visited[now] = true;
        for(int i = 0; i < arr[now].size(); ++i){
            Node next = arr[now].get(i);
            if(visited[next.u]) continue;
            dp[start][next.u] = Math.min(dp[start][now], next.k);
            dfs(start, next.u);
        }
    }
}
