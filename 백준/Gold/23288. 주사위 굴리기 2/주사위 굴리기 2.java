import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class Main {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int dice[] = {0,1,2,3,4,5,6};
    static int result = 0;
    static boolean visited[][];
    static int nowDir = 1;
    static int scores[][];
    public static class Pair{
        int y,x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int board[][] = new int[n+1][m+1];
        scores = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i) {
            st = new StringTokenizer(buf.readLine());
            for(int j = 1; j <= m; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Pair now = new Pair(1,1);
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= m; ++j){
                if(scores[i][j] == 0) {
                    visited= new boolean[n+1][m+1];
                    score(board, new Pair(i, j), n, m);
                }
            }
        }
        for(int i = 1; i <= k; ++i) {
            move(now, n, m);
            checkNext(board, now);
        }
        System.out.println(result);
    }
    public static void moveDice(int dir) {
        if(dir == 1) { // 동쪽
            int temp = dice[6];
            dice[6] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        }
        else if (dir == 2) { // 남쪽
            int temp = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;

        }
        else if (dir == 3) { //서쪽
            int temp = dice[6];
            dice[6] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        }
        else {
            int temp = dice[6];
            dice[6] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        }

    }
    public static void move(Pair now, int n , int m) {
        if(nowDir == 1) {
            if(now.x + 1 <= m){
                now.x += 1;
                moveDice(1);
            }
            else {
                now.x -= 1;
                moveDice(3);
                nowDir = 3;
            }
        }
        else if (nowDir == 2) {
            if(now.y + 1 <= n){
                now.y += 1;
                moveDice(2);
            }
            else {
                now.y -= 1;
                moveDice(4);
                nowDir = 4;
            }

        }
        else if (nowDir == 3) {
            if(0 < now.x - 1 ){
                now.x -= 1;
                moveDice(3);
            }
            else {
                now.x += 1;
                moveDice(1);
                nowDir = 1;
            }
        }
        else {
            if(0 < now.y - 1) {
                now.y -= 1;
                moveDice(4);
            }
            else {
                now.y += 1;
                moveDice(2);
                nowDir = 2;
            }
        }
    }
    public static void checkNext(int board[][], Pair now) {
        result += scores[now.y][now.x];
        if(board[now.y][now.x] < dice[6]) {
            nowDir = (nowDir + 1) % 5;
            if(nowDir == 0) nowDir = 1;
        }
        else if(board[now.y][now.x] > dice[6]) {
            nowDir = (nowDir - 1) % 5;
            if(nowDir == 0) nowDir = 4;
        }
    }
    public static void score(int board[][], Pair now, int n , int m) {
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(now);
        visited[now.y][now.x] = true;
        int num = board[now.y][now.x];
        int size = 0;
        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(now);
        while(!dq.isEmpty()){
            Pair temp = dq.removeFirst();
            size += 1;
            for(int i = 0; i < 4; ++i) {
                int ny = temp.y + dy[i];
                int nx = temp.x + dx[i];
                if(ny < 1 || ny > n || nx < 1 || nx > m) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                if(board[ny][nx] == num) {
                    dq.addLast(new Pair(ny,nx));
                    arr.add(new Pair(ny,nx));
                }
            }
        }
        for(int i = 0; i < arr.size(); ++i) {
            scores[arr.get(i).y][arr.get(i).x] = num*size;
        }
    }

}