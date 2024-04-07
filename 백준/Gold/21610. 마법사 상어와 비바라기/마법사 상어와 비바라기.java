import java.util.*;
import java.io.*;

public class Main {
    public static int dy[] = {0,-1,-1,-1,0,1,1,1};
    public static int dx[] = {-1,-1,0,1,1,1,0,-1};

    public static int clossY[] = {-1,-1,1,1};
    public static int clossX[] = {-1,1,1,-1};
    public static class Node{
        int y,x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static class Query{
        int d,c;
        public Query(int d, int c) {
            this.d = d;
            this.c = c;
        }
    }
    static int board[][];
    static boolean clouds[][];
    public static ArrayList<Node> cloud = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];

        for(int i = 1; i <= n; ++i) {
            st = new StringTokenizer(buf.readLine());
            for(int j = 1; j <= n; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Query> query = new ArrayList<>();
        for(int i = 0; i < m; ++i) {
            st = new StringTokenizer(buf.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            query.add(new Query(d, c));
        }
        cloud.add(new Node(n,1));
        cloud.add(new Node(n,2));
        cloud.add(new Node(n-1,1));
        cloud.add(new Node(n-1,2));

        for(int i = 0; i < query.size(); ++i) {
            clouds = new boolean[n+1][n+1];

            moveCloud(query.get(i), n);

            rain();

            checkWater(n);

            makeCloud(n);
        }
        int result = 0;
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                result += board[i][j];
            }
        }
        System.out.println(result);
    }

    public static Node checkNode(int n, int ny, int nx) {
        if(ny < 1) {
            while(ny < 1) {
                ny += n;
            }
        }
        else if(ny > n) {
            while(ny > n) {
                ny -= n;
            }
        }

        if(nx < 1) {
            while(nx < 1) {
                nx += n;
            }
        }
        else if(nx > n) {
            while(nx > n) {
                nx -= n;
            }
        }

        return new Node(ny, nx);
    }

    public static void moveCloud(Query query, int n) {
        for(int i = 0; i < cloud.size(); ++i) {
            int ny = cloud.get(i).y + (dy[query.d - 1] * query.c);
            int nx = cloud.get(i).x + (dx[query.d - 1] * query.c);
            Node node = checkNode(n, ny, nx);
            cloud.get(i).y = node.y;
            cloud.get(i).x = node.x;
        }
    }

    public static void rain() {
        for(int i = 0; i < cloud.size(); ++i) {
            board[cloud.get(i).y][cloud.get(i).x]++;
            clouds[cloud.get(i).y][cloud.get(i).x] = true;
        }
    }
    public static void checkWater(int n) {
        for(int i = 0; i < cloud.size(); ++i) {
            int count = 0;
            for(int j = 0; j < 4; ++j) {
                int ny = cloud.get(i).y + clossY[j];
                int nx = cloud.get(i).x + clossX[j];
                if (ny < 1 || ny > n || nx < 1 || nx > n)
                    continue;
                if (board[ny][nx] > 0)
                    ++count;
            }
            board[cloud.get(i).y][cloud.get(i).x] += count;
        }
        cloud.clear();
    }

    public static void makeCloud(int n) {
        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                if(clouds[i][j]) continue;
                if(board[i][j] >= 2) {
                    cloud.add(new Node(i, j));
                    board[i][j] -= 2;
                }
            }
        }
    }
}
