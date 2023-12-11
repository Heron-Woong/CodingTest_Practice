import java.io.*;
import java.util.*;

public class Main {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] charArray = new char[n][n];
        for (int i = 0; i < n; i++) {
            charArray[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checkSameNumber(charArray, i, j);
                checkArray(charArray, i ,j, n);
            }
        }
        System.out.println(result);
    }
    public static void checkArray(char[][] charArray, int y, int x, int n) {
        char[][] tempCharArray = charArray.clone();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;;
            if(tempCharArray[y][x] != tempCharArray[ny][nx]) {
                char temp = tempCharArray[y][x];
                tempCharArray[y][x] = charArray[ny][nx];
                tempCharArray[ny][nx] = temp;
                checkSameNumber(tempCharArray,y,x);
                checkSameNumber(tempCharArray,ny,nx);

                temp = tempCharArray[y][x];
                tempCharArray[y][x] = charArray[ny][nx];
                tempCharArray[ny][nx] = temp;
            }
        }
    }
    public static void checkSameNumber (char[][] tempCharArray, int y, int x) {
        int count = 1;
        for(int i = 1; i < tempCharArray.length; ++i) {
            if(tempCharArray[y][i-1] == tempCharArray[y][i]) {
                ++count;
            }
            else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);
        count= 1;
        for(int i = 1; i < tempCharArray.length; ++i) {
            if(tempCharArray[i-1][x] == tempCharArray[i][x]) {
                ++count;
            }
            else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);
    }
}