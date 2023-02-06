import java.util.Scanner;

public class 백준_1256 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        int arr[][] = new int [201][201];
        for(int i = 0; i<=200; ++i){
            for(int j = 0; j<=i; ++j){
                if(j == 0 || j == i) arr[i][j] = 1;
                else{
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                    if(arr[i][j] > 1000000000) arr[i][j] = 1000000001;
                }
            }
        }
        if(arr[n+m][m] < k){
            System.out.println(-1);
        } else{
            while(!(n == 0 && m == 0)){
                if(k <= arr[n+m-1][m]){
                    System.out.print("a");
                    n--;
                }else{
                    System.out.print("z");
                    k = k - arr[n+m-1][m];
                    m--;
                }
            }
        }

    }
}
