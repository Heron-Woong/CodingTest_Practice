import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> pro = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            st = new StringTokenizer(buf.readLine());
            String temp = st.nextToken();
            pro.add(temp);
        }
        int answer = 0;
        Collections.sort(pro);
        for(int i = 0; i < m; ++i){
            st = new StringTokenizer(buf.readLine());
            String temp = st.nextToken();
            if(binarySearch(temp, pro)) ++answer;
        }
        System.out.println(answer);
    }

    public static boolean binarySearch(String temp, ArrayList<String> pro) {
        int left = 0; int right = pro.size()-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(pro.get(mid).compareTo(temp) > 0) {
                right = mid - 1;
            }
            else if(pro.get(mid).compareTo(temp) < 0) {
                left = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}