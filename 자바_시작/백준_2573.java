import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class 백준_2573 {
    static class Pair{ // Pair 처리
        int y,x;
        Pair(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int n = 0;
    static int m = 0;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int arr[][]; // 입력 이차원 배열
    static int year = 0; // 정답
    static int zero_count = 0; // 주변에 0이 몇개인지 세기
    static boolean visited[][]; // 방문했는지 검사
    static boolean check[][]; // 방금 녹았는지 검사
    static int result=0; // 연결된 빙산의 갯수
    static ArrayList<Pair> ar; // 지금 빙산이 있는 좌표 모음
    static void sol(){ // 빙산 녹이기
        for (int i = ar.size()-1; i >= 0 ; i--) {
            int nowY = ar.get(i).y;
            int nowX = ar.get(i).x;
            if (arr[nowY][nowX] == 0) continue;
            else {
                for (int k = 0; k < 4; k++) {
                    int ny = nowY + dy[k];
                    int nx = nowX + dx[k];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (arr[ny][nx] == 0 && check[ny][nx] == false) {
                        zero_count++;
                    }
                }
                arr[nowY][nowX] -= zero_count;
                ar.remove(ar.get(i));
                if(arr[nowY][nowX] > 0) ar.add(new Pair(nowY, nowX));
                if (arr[nowY][nowX] <= 0) {
                    arr[nowY][nowX] = 0;
                    check[nowY][nowX] = true;
                }
                zero_count = 0;
            }
        }
    }
    static void BFS(int y, int x){ // 붙어있는 빙산 탐색
        if(visited[y][x] == true) return;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(arr[ny][nx] > 0) BFS(ny,nx);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ar = new ArrayList<>();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(buf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] >0) ar.add(new Pair(i,j));
            }
        }
        while(true) {
            check = new boolean[n][m];
            visited = new boolean[n][m];
            sol();
            ++year;
            if(ar.size() == 0){
                year=0;
                break;
            }
            for(Pair pa : ar){
                if(arr[pa.y][pa.x] <= 0 || visited[pa.y][pa.x] == true) continue;
                else {
                    BFS(pa.y,pa.x);
                    ++result;
                }
            }
            if(result >= 2) break;
            result = 0;
        }
        System.out.println(year);
    }
}
