import java.io.*;
import java.util.*;

public class Main {
    public static class Num{
        long num; int idx;
        public Num(long num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(buf.readLine());

        ArrayList<Num> nums = new ArrayList<>();
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums.add(new Num(Long.parseLong(st.nextToken()), i));
        }

        Collections.sort(nums, (n1, n2) -> {
            return (int) (n1.num - n2.num);
        });

        int idx = 0;
        long max = nums.get(idx).num;

        for (int i = 1; i < n; i++) {
            if(max == nums.get(i).num) {
                result[nums.get(i).idx] = idx;
            }
            else {
                max = nums.get(i).num;
                idx++;
                result[nums.get(i).idx] = idx;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}