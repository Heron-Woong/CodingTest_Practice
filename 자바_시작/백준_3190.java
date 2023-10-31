import java.util.*;

public class 백준_3190 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Map<Integer, String> moved;
    static Deque<Node> dq;
    static class Node{
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;
    }
    public static boolean Finish(int nx, int ny){
        for (Node d : dq){
            if(d.x == nx && d.y == ny){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int arr[][] = new int [N+1][N+1];
        int u=0; int v=0;
        for (int i = 0; i < k; i++) {
            u = sc.nextInt(); v= sc.nextInt();
            arr[u][v] = 1;
        }
        int L = sc.nextInt();
        int second;
        String dir;
        moved = new HashMap<>();
        for (int i = 0; i < L; i++) {
            second = sc.nextInt();
            dir = sc.next();
            moved.put(second,dir);
        }
        dq = new LinkedList<>();
        int x = 1; int y =1;
        int count=0;
        dq.add(new Node(1,1));
        int px = 1;
        int py = 1;
        int d =0;
        while(true){
            int nx = px + dx[d];
            int ny = py + dy[d];
            ++count;

            if(nx<1 || ny <1 || nx > N || ny > N){
                break;
            }
            if(Finish(nx,ny) == true){
                break;
            }
            if(arr[ny][nx] == 1){
                arr[ny][nx] = 0;
                dq.add(new Node(nx,ny));
            }else{
                dq.add(new Node(nx,ny));
                dq.removeFirst();
            }
            if(moved.containsKey(count)){
                String direction = moved.get(count);
                if(direction.equals("D")){
                    d += 1;
                    if(d==4) d=0;
                }else{
                    d -= 1;
                    if(d==-1) d=3;
                }
            }
            px = nx;
            py = ny;
        }
        System.out.println(count);
    }
}
