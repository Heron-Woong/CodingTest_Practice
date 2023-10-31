import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11660 {
    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
       int n = Integer.parseInt(stringTokenizer.nextToken());
       int m = Integer.parseInt(stringTokenizer.nextToken());
       int arr[][] = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int sum[][] = new int[n+1][n+1];
        sum[1][1] = arr[1][1];
        for (int i = 2; i <= n; i++) {
            sum[1][i] = arr[1][i] + sum[1][i-1];
            sum[i][1] = arr[i][1] + sum[i-1][1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u1 = Integer.parseInt(stringTokenizer.nextToken());
            int v1 = Integer.parseInt(stringTokenizer.nextToken());
            int u2 = Integer.parseInt(stringTokenizer.nextToken());
            int v2 = Integer.parseInt(stringTokenizer.nextToken());
            int res = sum[u2][v2] - sum[u1-1][v2] - sum[u2][v1-1] + sum[u1-1][v1-1];
            System.out.println(res);
        }
    }
}
