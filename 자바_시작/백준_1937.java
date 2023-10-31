import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1937 {
    static int n;
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0 , 1, -1};
    static int pro[][];
    static int cnt = 0;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        pro = new int[n][n];
        dp = new int[n][n];
        for(int i =0; i<n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j=0; j<n; ++j){
                pro[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                cnt = Math.max(cnt, DFS(i,j));
            }
        }
        System.out.println(cnt);
    }
    public static int DFS(int y, int x){
        if(dp[y][x] != 0) return dp[y][x];
        dp[y][x] = 1;
        int now = pro[y][x];
        for(int i =0; i<4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx <0 || nx >= n ) continue;
            if(pro[ny][nx] <= now) continue;
            dp[y][x] = Math.max(dp[y][x], DFS(ny,nx)+1);
        }
        return dp[y][x];
    }
}
