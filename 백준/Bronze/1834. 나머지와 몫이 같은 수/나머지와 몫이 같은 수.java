import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long num = 0;
        for(long i = 1; i < n; ++i){
            num += (i*n + i);
        }
        System.out.println(num);
    };
}
