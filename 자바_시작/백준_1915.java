import java.io.IOException;
import java.util.Scanner;


public class 백준_1915 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long pro[][] = new long[n][m];
        long max =0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                pro[i][j] = Long.parseLong(String.valueOf(str.charAt(j)));
                if(pro[i][j] == 1 && i > 0 && j > 0){
                    pro[i][j] = Math.min(pro[i-1][j-1], Math.min(pro[i-1][j], pro[i][j-1])) + pro[i][j];
                }
                max = Math.max(pro[i][j], max);
            }
        }
        System.out.println(max * max);
    }
}
