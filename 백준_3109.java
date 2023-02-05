import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_3109 {
    static char pro[][];
    static int R,C;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pro = new char[R][C];
        for(int i =0; i<R; ++i){
            pro[i] = buf.readLine().toCharArray();
        }
        int result = 0;
        for(int i =0; i<R; ++i){
            if(check(i,0)) ++result;
        }
        System.out.println(result);
    }
    public static boolean check(int y, int x){
        pro[y][x] = '-';
        if(x == C-1){
            return true;
        }
        if(y > 0 && pro[y-1][x+1] == '.') {
            if(check(y-1, x+1)) //오른쪽 위
               return true;
        }
        if(pro[y][x+1] == '.') {
            if(check(y,x+1)) // 오른쪽
                return true;
        }
        if(y < R-1 && pro[y+1][x+1] == '.') {
            if(check(y+1,x+1)) //오른쪽 아래
                return true;
        }
        return false;
    }
}
