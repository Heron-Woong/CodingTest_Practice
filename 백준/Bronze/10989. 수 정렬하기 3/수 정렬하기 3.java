import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        int nums[] = new int[10001];
        for (int i = 0; i < n; i++) {
            nums[Integer.parseInt(buf.readLine())]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < 10001; i++) {
            if(nums[i] != 0) {
                for (int j = 0; j < nums[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }
        bw.flush();
    }
}