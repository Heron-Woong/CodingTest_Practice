import java.util.*;
import java.io.*;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static final int dy[] = {-1, 0, 1, 0}; //북, 동, 남, 서
    static final int dx[] = {0, 1, 0, -1};
    static int n,m;
    static int answer = 0;
    static boolean check = false;
    static ArrayList<Node> temp = new ArrayList<>();
    static class Node{
        int y,x,d;
        public Node(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j = 0; j < m; ++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(r,c,d);
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(visited[i][j]) ++answer;
            }
        }
        System.out.println(answer);
    }
    public static void bfs(int y, int x, int d){
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(y,x,d));
        visited[y][x] = true;
        while(!dq.isEmpty()) {
            Node now = dq.removeFirst();
            visited[now.y][now.x] = true;
            temp.clear();
            for (int i = 0; i < 4; ++i) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (visited[ny][nx]) continue;
                if (arr[ny][nx] == 1) continue;
                else temp.add(new Node(ny, nx, i));
            }
            if(temp.size() == 0){
                int td = (now.d + 2) % 4;
                int ny = now.y + dy[td];
                int nx = now.x + dx[td];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) break;
                if(arr[ny][nx] == 1) break;
                else {
                    dq.add(new Node(ny, nx, now.d));
                }
            }
            else {
                int td = now.d;
                for(int i = 0; i < 4; ++i) {
                    td = (td + 3) % 4;
                    int ny = now.y + dy[td];
                    int nx = now.x + dx[td];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (visited[ny][nx]) continue;
                    if (arr[ny][nx] == 1) continue;
                    else {
                        visited[ny][nx] = true;
                        dq.add(new Node(ny, nx, td));
                        break;
                    }
                }
            }
        }
    }
}