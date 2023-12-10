import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int z = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        while(num != 0){
            nums.add(num % z);
            num /= z;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = nums.size()-1; i >= 0; i--) {
            if(nums.get(i) >= 10){
                sb.append((char)('A' + (nums.get(i) - 10)));
            }
            else sb.append(nums.get(i));
        }
        System.out.println(sb.toString());
    }

}