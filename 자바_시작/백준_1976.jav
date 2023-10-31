import java.util.Scanner;

public class 백준_1976 {
    static int[] arr;
    public static int find(int x){
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }

    public static void union_node(int x, int y){
        x = find(x);
        y = find(y);
        if(x < y) arr[y] = x;
        else arr[x] = y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if(num == 1){
                    union_node(i,j);
                }
            }
        }
        int root = 0;
        boolean check = true;
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            num = num-1;
            if(i==0) root = find(num);
            else{
                if(find(root) != find(num)){
                    check = false;
                    break;
                }
            }
        }
        if (check == true){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}
