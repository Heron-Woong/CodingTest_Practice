import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2263 {
    static int in[]; //인오더
    static int post[]; //포스트 오더
    static int pre[]; //프리 오더
    static int idx=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        in = new int[n];
        post = new int[n];
        pre = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        solution(0,n-1,0,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(pre[i] + " ");
        }
    }
    public static void solution(int in_l, int in_r, int po_l, int po_r){
        if(in_l <= in_r && po_l <= po_r){
            // 포스트오더에 맨 마지막 부분이 루트
            pre[idx++] = post[po_r];
            //다음 왼쪽 서브 트리가 끝나는 지점
            int temp_in_r = in_l;

            for (int i = in_l; i <= in_r; i++) {
                if(post[po_r] == in[i]) {
                    // 현재 루트와 인오더에서 같은 값 인덱스로 찾기
                    temp_in_r = i;
                    break;
                }
            }

            int count = temp_in_r - in_l -1; //서브트리의 노드 갯수

            //왼쪽 서브트리 탐사
            solution(in_l, temp_in_r-1, po_l, po_l + count);
            //오른쪽 서브트리 탐사
            solution(temp_in_r+1, in_r, po_l + count+1, po_r-1);
        }
    }
}
