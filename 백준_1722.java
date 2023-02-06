import java.util.Scanner;

public class 백준_1722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[21];
        long f[] = new long[21];
        boolean visited[] = new boolean[21];
        f[0] = 1;
        for(int i = 1; i<=n; ++i){
            f[i] = f[i-1]*i;
        }
        if(q == 1) {
            long k = sc.nextLong();
            for(int i =1; i<=n; ++i){
                int cnt =1;
                for(int j= 1; j<=n; ++j){
                    if(visited[j]) continue;
                    if(k <= f[n-i] * cnt) {
                        k -= (f[n-i]*(cnt-1));
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                    ++cnt;
                }
            }
            for(int i =1; i<=n; ++i){
                System.out.print(arr[i] + " ");
            }
        }
        else if(q==2){
            long k = 1;
            for(int i =1; i<=n; ++i){
                arr[i] = sc.nextInt();
                long cnt = 0;
                for(int j =1; j<arr[i]; ++j){
                    if(visited[j] == false) ++cnt;
                }
                k += (cnt) * f[n-i];
                visited[arr[i]] = true;
            }
            System.out.print(k);
        }


    }
}
