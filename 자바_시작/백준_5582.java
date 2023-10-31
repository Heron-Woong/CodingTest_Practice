import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_5582 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int [][] pro = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for(int i = 0; i< str1.length(); ++i){
            for(int j = 0; j<str2.length(); ++j){
                if(str1.charAt(i) == str2.charAt(j)){
                    pro[i+1][j+1] = pro[i][j] + 1;
                    max = Math.max(max, pro[i+1][j+1]);
                }
            }
        }
        System.out.println(max);
    }
}
