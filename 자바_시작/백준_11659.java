import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11659 {
    public static void main(String[] args) throws IOException {
        //많은 수를 빠르게 얻기 위해 Scanner 대신 BufferedReader를 사용한다.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer는 받은 문자열을 하나씩 나눈다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        long[] s = new long[n + 1];  //합을 계산할 구간 합 배열
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            //구간 합 구하기
            s[i] = s[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[v] - s[u - 1]);
        }
    }
}

