import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(buf.readLine());
        for(int i = 0; i < n; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int now = 0;
        int s = 1;
        int e = n - 1;
        int rResult = Integer.MAX_VALUE;
        int rs = 0; int re = 0;

        for(int i = 0; i < n; ++i) {
            now = i;
            s = i + 1;
            e = n - 1;

            while (s <= e) {
                int m = (s + e) / 2;
                int nowResult = nums[now] + nums[m];
                if (Math.abs(rResult) > Math.abs(nowResult)) {
                    rResult = nowResult;
                    rs = nums[now];
                    re = nums[m];
                }
                if (nowResult < 0) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }

        }
        System.out.println(rs + " " + re);
    }
}