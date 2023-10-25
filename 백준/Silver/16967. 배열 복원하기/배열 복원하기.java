import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer((buf.readLine()));
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int B[][] = new int[h+x][w+y];
        int A[][] = new int[h][w];
        for(int i = 0; i < h+x; ++i){
            st = new StringTokenizer((buf.readLine()));
            for(int j = 0; j < w+y; ++j){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < h; ++i){
            for(int j = 0; j < w; ++j){
                A[i][j] = B[i][j];
            }
        }

        for(int i = x; i < h; ++i){
            for(int j = y; j < w; ++j){
                A[i][j] = A[i][j] - A[i-x][j-y];
            }
        }

        for(int i = 0; i < h; ++i){
            for(int j = 0; j < w; ++j){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}