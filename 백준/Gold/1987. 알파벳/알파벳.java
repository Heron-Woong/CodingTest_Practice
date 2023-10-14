import java.util.*;

public class Main {
    static char[][] temp;
    static int dy[] = {-1, 0 , 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int r,c;
    static int answer = 0;
    static Set<Character> check = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        temp = new char[r][c];
        for(int i = 0; i < r; ++i){
            String str = sc.next();
            temp[i] = str.toCharArray();
        }
        check.add(temp[0][0]);
        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int y, int x){
        answer = Math.max(answer, check.size());
        for(int i = 0; i < 4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if(check.contains(temp[ny][nx])) continue;
            check.add(temp[ny][nx]);
            dfs(ny,nx);
            check.remove(temp[ny][nx]);
        }
    }
}