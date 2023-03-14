import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14503 {
    static int pro[][];
    static int r,c,d;
    static int count;
    static int n,m;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    static boolean end = false;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());
        r =  Integer.parseInt(st.nextToken());
        c =  Integer.parseInt(st.nextToken());
        d =  Integer.parseInt(st.nextToken());
        pro = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(buf.readLine());
            for (int j = 0; j < m; j++) {
                pro[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        nev(r,c,d);
        System.out.println(count);
    }
    public static void nev(int r , int c, int d){
        if(end) return;
        if(pro[r][c] == 1) return;
        if(pro[r][c] == 0) {
            pro[r][c] = 2;
            ++count;
        }
        boolean check = true;
        for(int i =0; i<4; ++i){
            int nx = c + dx[i];
            int ny = r + dy[i];
            if(pro[ny][nx] == 1) continue;
            if(nx<0 || ny <0 || nx >=m || ny >= n) continue;
            else if(pro[ny][nx] == 0) {
                check = false;
                break;
            }
        }
        if(check == false){
            d -= 1;
            if(d<0) d= 3;
            int nx =0; int ny =0;
            if(d == 0){
                nx = c;
                ny = r -1;
            }
            else if(d == 1){
                nx = c+ 1;
                ny = r;
            }
            else if(d==2){
                nx = c;
                ny = r+1;
            }
            else{
                nx=c-1;
                ny =r;
            }
            if(pro[ny][nx] == 0){
                nev(ny,nx,d);
            }
            else{
                nev(r,c,d);
            }
        }
        else{
            int nx =0; int ny =0;
            if(d == 0){
                nx = c;
                ny = r + 1;
            }
            else if(d == 1){
                nx = c - 1;
                ny = r;
            }
            else if(d==2){
                nx = c;
                ny = r - 1;
            }
            else{
                nx=c + 1;
                ny =r;
            }
            if(nx<0 || ny <0 || nx >=m || ny >= n){
                return;
            }
            if(pro[ny][nx] == 1) {
                end = true;
                return;
            }
            else{
                nev(ny,nx,d);
            }
        }
    }
}
