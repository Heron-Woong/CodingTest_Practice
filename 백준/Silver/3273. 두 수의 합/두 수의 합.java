import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buf.readLine());
        int []nums = Arrays.stream(buf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int x = Integer.parseInt(buf.readLine());
        int s = 0;
        int e = nums.length - 1;

        int res = 0;
        while(s < e) {
            if(nums[s] + nums[e] == x) {
                ++s;
                --e;
                ++res;
            }
            else if(nums[s] + nums[e] > x) {
                e--;
            }
            else if(nums[s] + nums[e] < x){
                s++;
            }
        }
        System.out.println(res);
    }
}