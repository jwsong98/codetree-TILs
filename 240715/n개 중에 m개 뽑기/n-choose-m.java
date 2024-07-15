import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N = 0;
    static int M = 0;

    /*
        정의
            nextIndex에 들어갈 숫자를 정함. + 이전에 넣은 숫자보다 큰 숫자부터 넣을 수 있음.
        처리 조건
            k in a[nextIndex - 1] + 1 ... N : call(nextIndex)
        종료
            nextIndex == M
    */
    static void fill(int [] arr, int nextIndex) {
        if (nextIndex == M) {
            for (int i = 0 ; i < M; i++) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        int startNum = 1;
        if (nextIndex >= 1) {
            startNum = arr[nextIndex - 1] + 1;
        }
        for (int i = startNum ; i <= N; i++) {
            arr[nextIndex] = i;
            fill(arr, nextIndex + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());
        int [] arr = new int[M];
        fill(arr, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}