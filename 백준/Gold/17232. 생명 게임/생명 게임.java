import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] boards = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i) {
            st = new StringTokenizer(buf.readLine());
            String str = st.nextToken();
            for(int j = 1; j <= m; ++j) {
                if(str.charAt(j-1) == '*') {
                    boards[i][j] = 1;
                }
                else boards[i][j] = 0;
            }
        }
        for(int i = 0; i < t; ++i) {
            int tempPrefixSums[][] = makePrefixSum(boards);

            for(int y = 1; y <= n; ++y) {
                for (int x = 1; x <= m; ++x) {
                    checkSide(a, b, k, tempPrefixSums, y, x, n, m, boards);
                }
            }
        }

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j) {
                if(boards[i][j] == 1) {
                    System.out.print("*");
                }
                else System.out.print(".");
            }
            System.out.println();
        }
    }
    public static int[][] makePrefixSum(int[][] boards) {
        int[][] prefixSum = new int[boards.length][boards[0].length];
        for(int i = 0; i < boards.length; ++i) {
            prefixSum[i] = boards[i].clone();
        }

        for(int i = 1; i < boards.length; ++i) {
            for(int j = 1; j < boards[i].length; ++j) {
                prefixSum[i][j] = prefixSum[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }
        return prefixSum;
    }
    public static void checkSide(int a, int b, int k, int[][] tempPrefixSums, int y, int x, int n, int m, int boards[][]) {
        int sy = y - k; int sx = x - k;
        int ey = y + k; int ex = x + k;
        if(sy <= 0) sy = 1; if(sx <= 0) sx = 1;
        if(ey > n) ey = n; if(ex > m) ex = m;
        int count = tempPrefixSums[ey][ex] - tempPrefixSums[sy-1][ex] - tempPrefixSums[ey][sx-1] + tempPrefixSums[sy-1][sx-1] ;
        if(boards[y][x] == 1) {
            count -= 1;
            if(a <= count && count <= b) {
                return;
            }
            else if (count < a) {
                boards[y][x] = 0;
            }
            else if (count > b) {
                boards[y][x] = 0;
            }
        }
        else {
            if(a < count && count <= b) {
                boards[y][x] = 1;
            }
        }

    }
}