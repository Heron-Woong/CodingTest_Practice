import java.util.*;

public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[201];
    for(int i = 0; i < n; ++i) {
        int num = sc.nextInt()+100;
        arr[num]++;
    }
    int v = sc.nextInt();
    System.out.println(arr[v+100]);
}
}