import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pro[] = new int[n];
        int sums[] = new int[n*(n+1)/2];
        int answer = 0;

        for(int i = 0; i < n; ++i){
            pro[i] = sc.nextInt();
        }

        int idx = 0;
        for(int i = 0; i < n; ++i){
            for(int j = i; j <n; ++j){
                sums[idx++] = pro[i] + pro[j];
            }
        }

        Arrays.sort(sums);

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                int num = pro[i] - pro[j];
                if(Arrays.binarySearch(sums, num) >= 0) {
                    answer = Math.max(answer, pro[i]);
                }
            }
        }

        System.out.println(answer);
    }
}