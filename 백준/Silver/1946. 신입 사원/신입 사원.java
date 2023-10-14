import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair> {
        int a,b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        public int compareTo(Pair p){
            return this.a - p.a;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i = 0; i < t; ++i){
            int n = sc.nextInt();
            for(int j = 0; j < n; ++j){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr.add(new Pair(a,b));
            }
            Collections.sort(arr);
            int sb = arr.get(0).b;
            int answer = 1;
            for(int k = 0; k < arr.size(); ++k){
                if(arr.get(k).b < sb){
                    ++answer;
                    sb = arr.get(k).b;
                }
            }
            System.out.println(answer);
            arr.clear();
        }
    }
}