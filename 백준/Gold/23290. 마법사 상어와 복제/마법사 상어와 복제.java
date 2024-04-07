import java.util.*;
import java.io.*;

public class Main {
    public static int dy[] = {0,-1,-1,-1,0,1,1,1};
    public static int dx[] = {-1,-1,0,1,1,1,0,-1};
    public static int sharkDy[] = {-1,0,1,0};
    public static int sharkDx[] = {0,-1,0,1};
    public static class Fish{
        int y,x,d;
        public Fish(int y, int x, int d){
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    public static ArrayList<Fish> map[][];
    public static ArrayList<Fish> nodes = new ArrayList<>();
    public static ArrayList<Fish> sharkPath = new ArrayList<>();
    public static ArrayList<Fish> tempSharkPath = new ArrayList<>();
    public static int[][] smell;
    public static boolean[][] visited;
    public static int sharkX;
    public static int sharkY;
    public static int max = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        smell = new int[5][5];
        map = new ArrayList[5][5];

        for(int i = 1; i <= 4; ++i){
            for(int j = 1; j <= 4; ++j) {
                map[i][j] = new ArrayList<Fish>();
            }
        }

        for(int i = 0; i < m; ++i) {
            st = new StringTokenizer(buf.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes.add(new Fish(y,x,d));
        }

        st = new StringTokenizer(buf.readLine());
        sharkY = Integer.parseInt(st.nextToken());
        sharkX = Integer.parseInt(st.nextToken());
        int result = 0;
        // 시작
        for(int i = 1; i <= s; ++i) {
            max = -1;

            ArrayList<Fish> first = new ArrayList<>();

            for(int j = 0; j < nodes.size(); ++j) {
                first.add(new Fish(nodes.get(j).y, nodes.get(j).x, nodes.get(j).d));
            }

            // 물고기 이동
            moveFish();

            // 물고기 배치
            setFish();

            // 상어 이동
            tempSharkPath.clear();
            moveShark(0, sharkY, sharkX);
            sharkY = sharkPath.get(sharkPath.size()-1).y;
            sharkX = sharkPath.get(sharkPath.size()-1).x;

            // 물고기 삭제 후 smell 추가
            deleteFish(i);

            // smell 삭제
            for(int j = 1; j <= 4; ++j) {
                for(int k = 1; k <= 4; ++k) {
                    if(smell[j][k] <= i - 2) smell[j][k] = 0;
                }
            }

            // 복제
            copyMap(first);

            // map에 list에 추가
            result = copyMaptoNodes();
        }
        System.out.println(result);
    }
    public static void moveFish() {
        for(int i = 0; i < nodes.size(); ++i) {
            Fish now = nodes.get(i);
            int tempD = now.d - 1;
            int count = 0;
            while(true) {
                if(count == 8) break;
                int fishNy = now.y + dy[tempD];
                int fishNx = now.x + dx[tempD];
                ++count;
                if(fishNy < 1 || fishNy > 4 || fishNx < 1 || fishNx > 4) {
                    tempD = (tempD - 1);
                    if(tempD < 0) tempD = 7;
                }
                else if(smell[fishNy][fishNx] != 0) {
                    tempD = (tempD - 1);
                    if(tempD < 0) tempD = 7;
                }
                else if((fishNy == sharkY) && (fishNx == sharkX)) {
                    tempD = (tempD - 1);
                    if(tempD < 0) tempD = 7;
                }
                else {
                    now.y = fishNy;
                    now.x = fishNx;
                    now.d = tempD + 1;
                    break;
                }
            }
        }
    }

    public static void setFish() {
        for(int i = 0; i < nodes.size(); ++i) {
            map[nodes.get(i).y][nodes.get(i).x].add(nodes.get(i));
        }
    }

    public static int calcScore() {
        int score = 0;
        for(int i = 0; i < tempSharkPath.size(); ++i) {
            Fish now = tempSharkPath.get(i);
            if(!visited[now.y][now.x]) {
                score += map[now.y][now.x].size();
                visited[now.y][now.x] = true;
            }
        }
        return score;
    }

    public static void moveShark(int count, int y, int x) {
        if(count == 3) {
            visited = new boolean[5][5];
            int tempScore = calcScore();
            if(max < tempScore) {
                max = tempScore;
                sharkPath.clear();
                sharkPath.addAll(tempSharkPath);
            }
            return;
        }
        for(int i = 0; i < 4; ++i) {
            int ny = y + sharkDy[i];
            int nx = x + sharkDx[i];
            if(ny < 1 || ny > 4 || nx < 1 || nx > 4) continue;
            tempSharkPath.add(new Fish(ny,nx,0));
            moveShark(count+1, ny, nx);
            tempSharkPath.remove(tempSharkPath.get(tempSharkPath.size()-1));
        }
    }

    public static void deleteFish(int t) {
        for(int i = 0; i < sharkPath.size(); ++i) {
            Fish now = sharkPath.get(i);
            if(map[now.y][now.x].size() > 0) {
                map[now.y][now.x].clear();
                smell[now.y][now.x] = t;
            }
        }
    }

    public static void copyMap(ArrayList<Fish> first) {
        for(int i = 0; i < first.size(); ++i) {
            Fish now = first.get(i);
            map[now.y][now.x].add(now);
        }
    }

    public static int copyMaptoNodes() {
        nodes.clear();
        int count = 0;
        for(int i = 1; i <= 4; ++i){
            for(int j = 1; j <= 4; ++j){
                for(int k = 0; k < map[i][j].size(); ++k){
                    nodes.add(map[i][j].get(k));
                    ++count;
                }
                map[i][j].clear();
            }
        }
        return count;
    }

}
