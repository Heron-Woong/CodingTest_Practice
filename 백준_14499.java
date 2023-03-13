import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14499 {
    static class dice{
        int top; int up; int down; int left; int right; int bottom;
        public dice(int top,int up, int down, int left, int right, int bottom){
            this.top = top;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }
    }
    static int pro[][];
    static int dice[];
    static int dx[] = {1,-1,0,0};   //동, 서 , 남 , 북
    static int dy[] = {0,0,-1,1};
    static int k = 0;
    static int n = 0;
    static int m = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pro= new int[n][m];
        dice= new int[7];
        for(int i = 0; i<n; ++i){
            st = new StringTokenizer(buf.readLine());
            for(int j = 0; j<m; ++j) {
               pro[i][j] =  Integer.parseInt(st.nextToken());
            }
        }
        dice curDice = new dice(0,1,2,3,4,5);
        int x = startX; int y = startY;
        st = new StringTokenizer(buf.readLine());
        for(int i = 0; i< k; ++i){
            int num = Integer.parseInt(st.nextToken());
            dice nextDice = null;
            if(num == 1){
                nextDice = new dice(curDice.left,curDice.up,curDice.down,curDice.bottom,curDice.top,curDice.right);
            }
            else if(num ==2){
                nextDice = new dice(curDice.right, curDice.up, curDice.down, curDice.top, curDice.bottom, curDice.left);
            }
            else if(num ==3){
                nextDice = new dice(curDice.up,curDice.bottom,curDice.top, curDice.left, curDice.right, curDice.down);
            }
            else if(num ==4){
                nextDice = new dice(curDice.down, curDice.top,curDice.bottom,curDice.left,curDice.right,curDice.up);
            }
            int nx = x + dx[num-1];
            int ny = y + dy[num-1];
            if(nx < 0 || nx >=m || ny < 0 || ny >= n) continue;
            curDice = nextDice;
            x = nx; y = ny;
            if(pro[ny][nx] != 0){
                dice[nextDice.bottom] = pro[ny][nx];
                pro[ny][nx] = 0;
                System.out.println(dice[nextDice.top]);
            }
            else{
                pro[ny][nx] = dice[nextDice.bottom];
                System.out.println(dice[nextDice.top]);
            }
        }
    }
}