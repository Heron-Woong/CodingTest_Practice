import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 백준_1874 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        int num=0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            num = scanner.nextInt();
            arr[i] = num;
        }
        StringBuffer bf = new StringBuffer();
        num = 1;
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            if(now >= num){
                while(now >= num){
                    st.push(num);
                    ++num;
                    bf.append("+\n");
                }
            }
            if(now == st.peek()){
                st.pop();
                bf.append("-\n");
            }
        }
        if(!st.isEmpty()){
            System.out.println("NO");
        }
        else{
            System.out.print(bf.toString());
        }
    }
}
