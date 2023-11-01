import java.io.*;
import java.util.*;

public class Main {
    static int dir[][][] = {
            {{0,0},{0,1},{0,2},{0,3}}, // -
            {{0,0},{1,0},{2,0},{3,0}}, // |
            {{0,0},{0,1},{1,1},{1,2}}, // ㄹ
            {{0,1},{1,0},{1,1},{2,0}},
            {{0,0},{0,1},{0,2},{1,2}}, // ㄱ
            {{0,0},{0,1},{1,0},{2,0}},
            {{0,0},{1,0},{1,1},{1,2}},
            {{0,1},{1,1},{2,1},{2,0}},
            {{0,0},{0,1},{1,0},{1,1}}, // ㅁ
            {{0,0},{1,0},{1,1},{2,0}}, // ㅏ
            {{0,1},{1,0},{1,1},{2,1}}, // ㅓ
            {{0,1},{1,0},{1,1},{1,2}}, // ㅗ
            {{0,0},{0,1},{0,2},{1,1}} // ㅜ
    };
    static int pro[][];
    static long answer = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int caseCount = 1;

        while (true) {
            answer = Long.MIN_VALUE;
            st = new StringTokenizer(buf.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            pro = new int[n][n];
            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(buf.readLine());
                for (int j = 0; j < n; ++j) {
                    pro[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    findMax(i,j,n);
                }
            }
            System.out.println(caseCount + ". " + answer);
            ++caseCount;
        }
    }

    public static boolean isRange(int y, int x, int n){
        if(y < 0 || y >= n || x < 0 || x >= n) return false;
        return true;
    }

    public static void findMax(int y, int x, int n){
        long sum = 0;
        int flag = 1;
        for(int k = 0; k < 13; ++k){
            sum = 0;
            flag = 1;
            for(int i = 0; i < 4; ++i){
                int nx = x + dir[k][i][1];
                int ny = y + dir[k][i][0];
                if(!isRange(ny,nx,n)) {
                    flag = 0;
                    break;
                }
                sum += pro[ny][nx];
            }
            if(flag == 1) answer = Math.max(answer, sum);
        }
    }

}