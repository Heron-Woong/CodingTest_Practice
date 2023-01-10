import java.util.Scanner;
import java.util.TreeSet;

public class 백준_2023 {
    static int n;
    static TreeSet<Integer> ts;
    static Boolean visit[] = new Boolean[10];
    static Boolean checkPrime(int x){
        int m = (int) Math.sqrt(x);
        for (int i = 2; i <= m ; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }
    static void DFS(int count, int num){
        if(count == n){
            ts.add(num);
            return;
        }
        num *= 10;
        for(int i=1; i<=9; ++i){
            if(checkPrime(num + i)){
                DFS(count+1, num+i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ts = new TreeSet<>();
        for (int i = 2; i <= 9; i++) {
            if(checkPrime(i)) {
                DFS(1, i);
            }
            else continue;
        }
        for(Integer num : ts){
            System.out.println(num);
        }
    }
}
