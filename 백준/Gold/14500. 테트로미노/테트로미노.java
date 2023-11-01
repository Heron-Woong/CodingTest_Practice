import java.util.*;
import java.io.*;

public class Main {
    static final int dy[] = {-1, 0, 1, 0}; // 북, 서, 남, 동
    static final int dx[] = {0, -1, 0, 1};
    static int n,m;
    static int arr[][];
    static int answer = 0;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j = 0; j < m; ++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                visited[i][j] = true;
                dfs(i,j,0,arr[i][j]);
                dfs2(i,j);
                visited[i][j] = false;
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int y, int x, int num, int sum){
        if(num == 3){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < 4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >=m)continue;
            if(visited[ny][nx]) continue;
            visited[ny][nx] = true;
            dfs(ny,nx,num+1, sum+arr[ny][nx]);
            visited[ny][nx] = false;
        }
    }
    public static void dfs2(int y, int x){
        boolean check = true;
        for(int i = 0; i < 4; ++i){;
            int sum = arr[y][x];
            check = true;
            for(int j = 0; j < 3; ++j){
                int ny = y + dy[(i+j)%4];
                int nx = x + dx[(i+j)%4];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    check = false;
                    break;
                }
                sum += arr[ny][nx];
            }
            if(check) {
                answer = Math.max(answer, sum);
            }
        }
    }
}