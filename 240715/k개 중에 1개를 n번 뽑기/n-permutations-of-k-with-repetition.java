import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N = 0;
    static int K = 0;

    /*
        1. 0 ~ nextIndex - 1까지 채운 상태에서 다음 인덱스에 올 값을 결정하는 함수
        2. call again with nextIndex + 1
        3. nextIndex == N
    */

    static void fill(int [] ans, int nextIndex) {
        if (nextIndex == N) {
            for (int i = 0 ; i < N ; i++) {
                sb.append(ans[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int k = 1 ; k <= K ; k++) {
            ans[nextIndex] = k;
            fill(ans, nextIndex + 1);
        }
        return ;
    }
    
    public static void main(String[] args) throws Exception {
        StringTokenizer NK = new StringTokenizer(br.readLine());
        K = Integer.parseInt(NK.nextToken());
        N = Integer.parseInt(NK.nextToken());
        int [] ans = new int [N];
        fill(ans, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}