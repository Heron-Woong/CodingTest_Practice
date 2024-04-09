import java.util.*;
import java.io.*;

public class Main {
    public static boolean block[][];
    public static boolean visited[][];
    public static int gravity[];
    public static int board[][];
    public static int dy[] = {-1, 0 , 1, 0};
    public static int dx[] = {0, -1, 0, 1};
    public static int count = 0;
    public static int countRain = 0;
    public static int max = 0;
    public static Node standardNode;
    public static int ans;
    public static class Node{
        int y,x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        for(int i = 0; i < n; ++i) {
            st = new StringTokenizer(buf.readLine());
            for(int j = 0; j < n; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
           check(n);
           score(n);
           gravity(n);
           rotateBoard(n);
           gravity(n);
        }

    }
    public static void score(int n) {
        int score = 0;
        Deque<Node> nodes = new ArrayDeque<>();
        int color = board[standardNode.y][standardNode.x];
        visited = new boolean[n][n];
        nodes.add(standardNode);
        visited[standardNode.y][standardNode.x] = true;
        while(!nodes.isEmpty()) {
            Node now = nodes.removeFirst();
            board[now.y][now.x] = -5;
            score++;
            for (int i = 0; i < 4; ++i) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visited[ny][nx] || board[ny][nx] == -1 || board[ny][nx] == -5) continue;
                if(color == 0 && board[ny][nx] != 0) {
                    color = board[ny][nx];
                }
                if(color == board[ny][nx] || board[ny][nx] == 0) {
                    nodes.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
        ans += Math.pow(score, 2);
    }
    public static void check(int n) {
        Deque<Node> dqGeneral = new ArrayDeque<>();
        Deque<Node> dqRainbow = new ArrayDeque<>();
        int max = 0; int rainMax = 0;
        visited = new boolean[n][n];
        standardNode = new Node(0 , 0);
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                int size = 0; int rain = 0; int color = 0; Node temp;
                if(!visited[i][j] && board[i][j] != -1 && board[i][j] != 0 && board[i][j] != -5) {
                    dqGeneral.add(temp = new Node(i, j));
                    visited[i][j] = true;
                    color = board[i][j];
                    size++;
                }
                while(!dqGeneral.isEmpty()) {
                    Node tmp = dqGeneral.removeFirst();
                    for(int k = 0; k < 4; ++k) {
                        int nx = tmp.x + dx[k];
                        int ny = tmp.y + dy[k];
                        if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                            if(!visited[ny][nx] && board[ny][nx] != -1 && board[ny][nx] != -5) {
                                if(color == board[ny][nx] || board[ny][nx] == 0) {
                                    if(board[ny][nx] == 0) {
                                        dqRainbow.add(new Node(ny, nx));
                                        rain++;
                                    }
                                    visited[ny][nx] = true;
                                    dqGeneral.add(new Node(ny, nx));
                                    size++;
                                }
                            }
                        }
                    }
                }
                if(max < size) {
                    max = size; rainMax = rain;
                    standardNode = new Node(i, j);
                }
                else if(max == size) {
                    if(rainMax < rain) {
                        rainMax = rain;
                        standardNode = new Node(i, j);
                    }
                    else if(rainMax == rain) {
                        if(standardNode.y < i) {
                            standardNode = new Node(i, j);
                        }
                        else if(standardNode.y == i) {
                            if(standardNode.x < j) {
                                standardNode = new Node(i, j);
                            }
                        }
                    }
                }
                while(!dqRainbow.isEmpty()) {
                    Node tmp = dqRainbow.removeFirst();
                    visited[tmp.y][tmp.x] = false;
                }
            }
        }
        if(max < 2) {
            System.out.println(ans);
            System.exit(0);
        }

    }
    public static void gravity(int n) {
        for(int i = n-2; 0 <= i; i--) {
            for(int j = 0; j < n; ++j) {
                if(board[i][j] == -5 || board[i][j] == -1) continue;
                int tmp = board[i][j];
                int ni = i;
                while(ni + 1 < n && board[ni+1][j] == -5) {
                    ni++;
                }
                if(board[ni][j] == -5) {
                    board[ni][j] = tmp;
                    board[i][j] = -5;
                }
            }
        }
    }

    public static void rotateBoard(int n) {
        int newBoard[][] = new int [n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                newBoard[n-1-j][i]  = board[i][j];
            }
        }
        for(int i = 0; i < n; ++i) {
            System.arraycopy(newBoard[i], 0, board[i], 0, newBoard[i].length);
        }
    }


}
