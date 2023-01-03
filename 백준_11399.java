import java.util.*;

public class 백준_11399 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sol[] = new int[n];
        sol[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sol[i] = arr[i] + sol[i-1];
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += sol[i];
        }
        System.out.println(sum);
    }
}
