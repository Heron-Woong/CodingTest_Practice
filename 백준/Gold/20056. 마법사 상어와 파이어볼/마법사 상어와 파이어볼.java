import java.util.*;
import java.io.*;

public class Main {
    public static int dy[] = {-1,-1,0,1,1,1,0,-1};
    public static int dx[] = {0,1,1,1,0,-1,-1,-1};
    public static class Node{
        int y,x,m,s,d;
        public Node(int y, int x, int m, int s, int d){
            this.y = y;
            this.x = x;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static ArrayList<Node> board[][];
    public static ArrayList<Node> nodes;
    public static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new ArrayList[N+1][N+1];
        nodes = new ArrayList<>();
        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= N; ++j) {
                board[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(buf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes.add(new Node(r,c,m,s,d));
        }
        for(int i = 0; i < k; ++i) {
            moveFireBall(N);
            divideFire(N);
        }
        for(Node node : nodes) {
            result += node.m;
        }
        System.out.println(result);
    }
    public static void moveFireBall(int N) {
        for(int i = 0; i < nodes.size(); ++i) {
            Node cur = nodes.get(i);
            int ny = (cur.y + N + (cur.s % N) * dy[cur.d]) % N + 1;
            int nx = (cur.x + N + (cur.s % N) * dx[cur.d]) % N + 1;

            if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
            cur.y = ny;
            cur.x = nx;
            board[cur.y][cur.x].add(cur);
        }
    }
    public static void divideFire(int N) {
        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= N; ++j) {
                if(board[i][j].size() < 2){
                    board[i][j].clear();
                    continue;
                }
                int mSum = 0; int sSum = 0;
                int oddCount = 0; int evenCount = 0;
                int size = board[i][j].size();
                for(Node node : board[i][j]) {
                    mSum += node.m;
                    sSum += node.s;
                    if(node.d % 2 == 1)
                        oddCount++;
                    else evenCount++;
                    nodes.remove(node);
                }
                board[i][j].clear();
                mSum /= 5;
                if(mSum == 0) continue;
                sSum /= size;
                if(oddCount == size || evenCount == size) {
                    for(int k = 0; k < 8; k+=2) {
                        nodes.add(new Node(i,j,mSum,sSum,k));
                    }
                }
                else {
                    for(int k = 1; k < 8; k+=2) {
                        nodes.add(new Node(i,j,mSum,sSum,k));
                    }
                }
            }
        }
    }
}
