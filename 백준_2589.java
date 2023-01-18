import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준_2589 {
    static class Node{
        public Node(int y, int x){
            this.x=x;
            this.y=y;
        }
        int x; int y;
    }
    static int n;
    static int m;
    static String arr[][];
    static int dx[] = {0,1,0,-1};
    static int dy[] = {-1,0,1,0};
    static boolean visited[][];
    static int check [][];
    static int max = 0;
    static Deque<Node> dq = new ArrayDeque<>();
    public static void sol(int y, int x){
        dq.add(new Node(y,x));
        while(!dq.isEmpty()){
            Node nd = dq.removeFirst();
            visited[nd.y][nd.x] = true;
            max = Math.max(max, check[nd.y][nd.x]);
            for(int i=0; i<4; ++i){
                int ny = nd.y + dy[i];
                int nx = nd.x + dx[i];
                if(ny < 0 || ny >= n || nx <0 || nx >= m) continue;
                if(visited[ny][nx]) continue;
                if(arr[ny][nx].equals("L")) {
                    dq.addLast(new Node(ny,nx));
                    visited[ny][nx] = true;
                    check[ny][nx] = check[nd.y][nd.x] + 1;
                }
            }
        }
        dq.clear();
    }

    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(buf.readLine());
            String str = st.nextToken();
            for(int j=0; j<m; ++j){
                arr[i][j] = str.substring(j,j+1);
            }
        }
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j){
                visited = new boolean[n][m];
                check = new int[n][m];
                if(arr[i][j].equals("W")) continue;
                else {
                    sol(i,j);
                }
            }
        }
        System.out.println(max);
    }
}
