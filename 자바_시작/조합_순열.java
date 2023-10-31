import java.util.ArrayList;

public class 조합_순열 {
    static int arr[];
    static boolean visited[];
    static ArrayList<Integer> temp;
    static int output[];
    public static void main(String[] args) {
       arr = new int[]{1, 2, 3, 4, 5};
       visited = new boolean[arr.length];
       output = new int[arr.length];
        for (int i = 1; i <= arr.length; i++) {
            temp = new ArrayList<>();
            perm(0,i);
        }


    }
    static void comb1(int start, int r){
        if(r == 0){
            for (int i = 0; i < visited.length ; i++) {
                if(visited[i]) temp.add(i+1);
            }
            for (int i = 0; i < temp.size() ; i++) {
                System.out.print(temp.get(i) + " ");
            }
            System.out.println();
            temp.clear();
            return;
        } else{
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(i+1,r-1);
                visited[i] = false;
            }
        }
    }

    static void comb2(int depth, int r){
        if(r == 0){
            for (int i = 0; i < visited.length ; i++) {
                if(visited[i]) temp.add(i+1);
            }
            for (int i = 0; i < temp.size() ; i++) {
                System.out.print(temp.get(i) + " ");
            }
            System.out.println();
            temp.clear();
            return;
        }
        if(depth == arr.length) return;
        else{
            visited[depth] = true;
            comb2(depth+1, r-1);

            visited[depth] = false;
            comb2(depth+1, r);
        }
    }

    static void perm(int depth, int r){
        if(depth == r){
            for (int i = 0; i < r; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            if(visited[i] != true){
                visited[i]=true;
                output[depth] = arr[i];
                perm(depth+1,r);
                visited[i]=false;
            }
        }
    }


}
