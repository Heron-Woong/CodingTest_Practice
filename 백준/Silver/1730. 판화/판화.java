import java.io.*;
import java.util.*;

public class Main {
    public static int dy[] = {-1, 0, 1, 0}; // U, R, D, L
    public static int dx[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        String str = buf.readLine();
        char[][] boards = new char[n][n];
        int [][][] tempBoard = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(boards[i], '.');
        }

        int y = 0; int x = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            int dir = idDir(temp);
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(!isRange(ny,nx,n)) continue;

            if(dir == 0 || dir == 2) {
                tempBoard[y][x][0] = 1;
                tempBoard[ny][nx][0] = 1;
            }
            else {
                tempBoard[y][x][1] = 1;
                tempBoard[ny][nx][1] = 1;
            }
            checkBoard(tempBoard, boards, y, x);
            checkBoard(tempBoard, boards, ny, nx);

            y = ny;
            x = nx;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(boards[i][j]);
            }
            System.out.println();
        }
    }

    public static int idDir(char dir) {
        if(dir == 'U') return 0;
        if(dir == 'R') return 1;
        if(dir == 'D') return 2;
        return 3;
    }

    public static void checkBoard(int[][][] tempBoard, char[][] boards, int y, int x) {
        if(tempBoard[y][x][0] == 1 && tempBoard[y][x][1] == 1) {
            boards[y][x] = '+';
        }
        else if (tempBoard[y][x][0] == 1) {
            boards[y][x] = '|';
        }
        else if (tempBoard[y][x][1] == 1) {
            boards[y][x] = '-';
        }
    }

    public static boolean isRange(int y, int x, int n) {
        if(y < 0 || y >= n || x < 0 || x >= n) return false;
        return true;
    }

}
