import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14500 {
    static int result=0;
    static int n,m;
    static boolean visited[][];
    static int arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void solve(int y, int x, int count, int sum){
        if(count == 4){
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m){
                continue;
            }
            if(!visited[ny][nx]){
                visited[ny][nx] = true;
                solve(ny, nx,count+1, sum +arr[ny][nx]);
                visited[ny][nx] = false;
            }
        }
    }

    public static void solve2(int y, int x, int sum, int count, int start){
        if(count == 3){
            result = Math.max(result, sum);
            return;
        }
        for (int i = start; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= m){
                continue;
            }
            solve2(y, x,sum+arr[ny][nx], count+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                solve(i,j,1, arr[i][j]);
                visited[i][j] = false;
                solve2(i,j,arr[i][j],0,0);
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}
