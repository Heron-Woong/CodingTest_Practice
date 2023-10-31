import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 백준_1253_자료구조 {
    static int N;
    static HashMap<Integer, Integer> maps = new HashMap<>();
    static int arr[];
    static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N= Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if(maps.containsKey(arr[i])){
                maps.put(arr[i], maps.get(arr[i])+1);
            }
            else{
                maps.put(arr[i],1);
            }
        }
        int sum=0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                sum = arr[i] + arr[j];
                int check;
                if(maps.containsKey(sum)){
                    check = maps.get(sum);
                    if(arr[i] == 0 && arr[j] == 0){
                        if(check >= 3){
                            result = result + check;
                            maps.remove(sum);
                        }
                    }
                    else if(arr[i] == 0 || arr[j] == 0){
                        if(check >= 2){
                            result = result + check;
                            maps.remove(sum);
                        }
                    }
                    else{
                        result = result + check;
                        maps.remove(sum);
                    }
                }
            }
        }
        System.out.println(result);
    }
}
