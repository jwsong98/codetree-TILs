import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
    static int K = 0;
    static int N = 0;

    /*
        함수 : nextIndex에 들어갈 숫자를 정하고 넣는 함수
        재귀 함수 호출 :
            a[nextIndex - 1] == a[nextIndex - 2] : 이 값은 제외
            else : 1...K
        종료 : nextIndex == N
    */
    static void fill(int [] arr, int nextIndex) {
        if (nextIndex == N) {
            for (int i = 0 ; i < N ; i++) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        int dupNum = -1;
        if (nextIndex >= 2 && arr[nextIndex - 1] == arr[nextIndex - 2]) {
            dupNum = arr[nextIndex - 1];
        }
        for (int k = 1 ; k <= K; k++) {
            if (k == dupNum) continue;
            arr[nextIndex] = k;
            fill(arr, nextIndex + 1);
        }
        return ;
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer KN = new StringTokenizer(br.readLine());
        K = Integer.parseInt(KN.nextToken());
        N = Integer.parseInt(KN.nextToken());
        int [] arr = new int[N];
        fill(arr, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}