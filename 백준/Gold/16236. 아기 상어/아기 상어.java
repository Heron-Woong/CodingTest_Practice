import java.util.*;
import java.io.*;

public class Main {
    public static class Node{
        int y,x,t;
        public Node(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }
    public static int dy[] = {-1, 0, 1, 0};
    public static int dx[] = {0, -1, 0, 1};
    static int result = 0;
    public static boolean visited[][];
    public static int board[][];
    public static int sharkSize = 2;
    public static int sharkEatCount = 0;
    public static Node shark;
    public static ArrayList<Node> fishEat = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        int checkSum = 0;
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(buf.readLine());
            for(int j = 0; j < n; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9) {
                    shark = new Node(i, j, 0);
                    board[i][j] = 0;
                }
                else checkSum += board[i][j];
            }
        }
        if(checkSum != 0) {
            while(true) {
                visited = new boolean[n][n];
                BFS(n, shark.y, shark.x);
                if(fishEat.isEmpty()) break;
                checkFish();
            }
        }
        System.out.println(result);
    }
    public static void checkFish() {
        fishEat.sort((f1,f2) -> {
            if(f1.t == f2.t) {
               if(f1.y == f2.y) return f1.x - f2.x;
               return f1.y - f2.y;
            }
            return f1.t - f2.t;
        });
        shark.y = fishEat.get(0).y;
        shark.x = fishEat.get(0).x;
        board[fishEat.get(0).y][fishEat.get(0).x] = 0;
        ++sharkEatCount;
        if(sharkEatCount == sharkSize) {
            sharkEatCount = 0;
            ++sharkSize;
        }
        result += fishEat.get(0).t;
        fishEat.clear();
    }
    public static void BFS(int n, int y, int x) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.addFirst(new Node(y, x, 0));
        visited[y][x] = true;
        while(!dq.isEmpty()) {
            Node now = dq.removeFirst();
            if(board[now.y][now.x] != 0 && board[now.y][now.x] < sharkSize) {
                fishEat.add(new Node(now.y, now.x, now.t));
            }
            for(int i = 0; i < 4; ++i) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(visited[ny][nx]) continue;
                if(board[ny][nx] > sharkSize) continue;
                visited[ny][nx] = true;
                dq.addLast(new Node(ny, nx, now.t + 1));
            }
        }
    }
}
