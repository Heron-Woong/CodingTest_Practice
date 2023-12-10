import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<Integer> nums = new ArrayList<>();
    static boolean  check = false;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            check = false;
            if (checkTrue(num)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
    public static boolean checkTrue (int num) {
        int temp = 0;
        int idx = 0;

        for (int i = 1; i < num; i++) {
            temp += i;
            if(temp >= num) {
                idx = i;
                break;
            }
        }

        int arr[] = new int[idx+1];
        arr[1] = 1;
        for (int i = 2; i <= idx; i++) {
            arr[i] = arr[i-1] + i;
        }
        checkNum(arr, idx, num);

        if(check) return true;
        return false;
    }

    public static void checkNum (int arr[], int idx, int num) {
        if(check) return;
        if(nums.size() == 3){
            int temp = arr[nums.get(0)] + arr[nums.get(1)] + arr[nums.get(2)];
            if(temp == num) {
                check = true;
            }
            return;
        }
        for (int i = 1; i <= idx; i++) {
            nums.add(i);
            checkNum(arr, idx, num);
            nums.remove(nums.size()-1);
        }
    }
}