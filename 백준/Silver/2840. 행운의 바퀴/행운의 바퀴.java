import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int idx = 0;
        char[] wheels = new char[n];
        Arrays.fill(wheels, ' ');
        boolean checkAlphabet[] = new boolean[26];

        boolean check = true;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(buf.readLine());
            int s = Integer.parseInt(st.nextToken());
            char wheel = st.nextToken().charAt(0);
            idx = (idx - s);
            while(idx < 0) {
                idx = n + idx;
            }
            if(wheels[idx] != ' ') {
                if(wheels[idx] == wheel) {
                    continue;
                }
                check = false;
            }
            else {
                if(checkAlphabet[wheel - 'A']) {
                    check = false;
                    continue;
                }
                checkAlphabet[wheel - 'A'] = true;
                wheels[idx] = wheel;
            }
        }

        if(!check) {
            System.out.println("!");
        }
        else {
            for (int i = idx; i < wheels.length; i++) {
                if (wheels[i] == ' ') {
                    System.out.print("?");
                }
                else System.out.print(wheels[i]);
            }
            for (int i = 0; i < idx; i++) {
                if (wheels[i] == ' ') {
                    System.out.print("?");
                }
                else System.out.print(wheels[i]);
            }
        }
    }
}
