import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer> pro[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            pro[i] = new ArrayList<>();
        }
        int result[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(buf.readLine());
            result[i][0] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                pro[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < n; i++) {
            result[i][1] = checkCount(pro[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
    public static int checkCount(ArrayList<Integer> pro) {
        int res = 0;
        int max = pro.get(0);
        for (int i = 1; i < pro.size(); i++) {
            if(max > pro.get(i)) {
                for (int j = 0; j < i; j++) {
                    if(pro.get(j) > pro.get(i)) {
                        int temp = pro.get(i);
                        pro.remove(pro.get(i));
                        pro.add(j,temp);
                        res += i - j;
                        break;
                    }
                }
            }
            max = Math.max(pro.get(i), max);
        }
        return res;
    }
}