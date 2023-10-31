import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class 백준_5639 {
    static ArrayList<Integer> arr;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        arr = new ArrayList<>();
        String input = "";
        while(true){
            input = buf.readLine();
            if(input == null || input.equals("")) break;
            arr.add(Integer.parseInt(input));
        }
        DFS(0,arr.size()-1);
        System.out.println(sb);
    }

    public static void DFS(int left, int right){
        if(left > right) return;
        int mid = left + 1;
        while(mid <= right && arr.get(mid) < arr.get(left)){
            mid++;
        }
        DFS(left+1, mid-1);
        DFS(mid, right);
        sb.append(arr.get(left).toString() + "\n");
    }
}
