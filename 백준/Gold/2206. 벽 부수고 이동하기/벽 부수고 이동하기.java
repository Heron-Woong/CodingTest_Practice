import java.io.*;
import java.util.*;

public class Main {
    public static class Block{
        int y; int x; int count; int crush;
        public Block(int y, int x, int count, int crush) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.crush = crush;
        }
    }
    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int pro[][] = new int[n][m];
        boolean visited[][][] = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                pro[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        Deque<Block> dq = new ArrayDeque<>();
        visited[0][0][0] = true;
        dq.add(new Block(0,0,1,0));
        int result = Integer.MAX_VALUE;
        while(!dq.isEmpty()) {
            Block now = dq.removeFirst();
            if(now.y == n-1 && now.x == m-1) {
               result = Math.min(result, now.count);
               continue;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx][now.crush]) continue;
                visited[ny][nx][now.crush] = true;
                if(pro[ny][nx] == 1 && now.crush == 0) {
                    dq.add(new Block(ny, nx, now.count+1, 1));
                }
                if(pro[ny][nx] == 0) {
                    dq.add(new Block(ny, nx, now.count+1, now.crush));
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else System.out.println(result);
    }
}
