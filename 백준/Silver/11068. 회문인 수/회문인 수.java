import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if (checkNum(num)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    public static boolean checkNum(int num) {
        for(int i = 2; i <= 64; ++i) {
            if(isCheck(num, i)) return true;
        }
        return false;
    }
    public static boolean isCheck(int num, int b) {
        ArrayList<Integer> nums = new ArrayList<>();
        while(num != 0) {
            nums.add(num % b);
            num /= b;
        }
        for(int i = nums.size() - 1; i >= nums.size()/2; --i) {
            if(nums.get(i) != nums.get(nums.size() - i - 1)) {
               return false;
            }
        }
        return true;
    }
}
