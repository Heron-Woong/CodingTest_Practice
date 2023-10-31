import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class 백준_1662 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> mul = new Stack<>();
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                count -= 1;
                int num = str.charAt(i-1) -'0';
                st.add(count);
                mul.add(num);
                count =0;
            }
            else if(str.charAt(i) == ')') {
                int val = mul.pop();
                val *= count;
                int plus = st.pop();
                count = plus + val;
            }
            else {
                count ++;
            }
        }
        System.out.println(count);
    }
}
