import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11758 {
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String []args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Node arr[] = new Node[3];
        for(int i =0; i<3; ++i){
            st = new StringTokenizer(buf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Node n = new Node(x,y);
            arr[i] = n;
        }
        int num1 = (arr[0].x * arr[1].y) + (arr[1].x * arr[2].y) + (arr[2].x * arr[0].y);
        int num2 = (arr[1].x * arr[0].y) + (arr[2].x * arr[1].y) + (arr[0].x * arr[2].y);
        int result = num1 - num2;
        if(result < 0) System.out.println(-1);
        else if(result == 0) System.out.println(0);
        else System.out.println(1);
    }
}
