import java.util.*;
import java.io.*;

public class Main {
    public static class Seat{
        int y,x,emptyCnt,friendCnt;
        public Seat(int y, int x, int emptyCnt, int friendCnt){
            this.y = y;
            this.x = x;
            this.emptyCnt = emptyCnt;
            this.friendCnt = friendCnt;
        }
    }

    static int[] dy = {1, 0 , -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] seats;
    static HashMap<Integer, ArrayList<Integer>> maps;

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        maps = new HashMap<>();
        seats = new int[n][n];
        for (int i = 0; i < n*n; ++i) {
            st = new StringTokenizer(buf.readLine());
            int student = Integer.parseInt(st.nextToken());
            ArrayList<Integer> friends = new ArrayList<>();
            for (int j = 0; j < 4; ++j) {
                friends.add(Integer.parseInt(st.nextToken()));
            }
            maps.put(student, friends);

            findSeats(n, student);
        }
        System.out.println(checkScore(n));
    }
    public static void findSeats(int n, int now) {
        ArrayList<Seat> seatCheck = new ArrayList<>();
        int emptyCount = 0;
        int bestFriend = 0;
        int ny = 0;
        int nx = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                emptyCount = 0;
                bestFriend = 0;
                if(seats[i][j] != 0) continue;
                for(int k = 0; k < 4; ++k){
                   ny = i + dy[k];
                   nx = j + dx[k];
                   if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                   if(seats[ny][nx] == 0) emptyCount++;
                   else {
                       if(maps.get(now).contains(seats[ny][nx])) ++bestFriend;
                   }
                }

                seatCheck.add(new Seat(i,j,emptyCount,bestFriend));
            }
        }

        seatCheck.sort((s1, s2) -> {
            if(s1.friendCnt == s2.friendCnt) {
                if(s1.emptyCnt == s2.emptyCnt) {
                    if(s1.y == s2.y) {
                        return s1.x - s2.x;
                    }
                    return s1.y-s2.y;
                }
                return s2.emptyCnt - s1.emptyCnt;
            }
            return s2.friendCnt - s1.friendCnt;
        });

        for(int i = 0; i < seatCheck.size(); ++i) {
            if (seats[seatCheck.get(i).y][seatCheck.get(i).x] == 0) {
                seats[seatCheck.get(i).y][seatCheck.get(i).x] = now;
                break;
            }
        }
    }

    public static int checkScore(int n) {
        int ny = 0;
        int nx = 0;
        int count = 0;
        int result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                count = 0;
                for (int k = 0; k < 4; ++k) {
                    ny = i + dy[k];
                    nx = j + dx[k];
                    if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                    if(maps.get(seats[i][j]).contains(seats[ny][nx])) ++count;
                }

                if(count == 1) result += 1;
                else if(count == 2) result += 10;
                else if(count == 3) result += 100;
                else if(count == 4) result += 1000;
            }
        }
        return result;
    }

}