import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N = 0;

    /*
        정의: 0...nextIndex - 1에 넣었던 수는 제외하고, nextIndex에 넣을 수를 정하는 함수
        함수: 0...nextIndex - 1에 넣었던 수 제외한 숫자들 가운데 가장 작은 수부터 차례로 넣는다.
        종료: nextIndex == N
    */
    static void fill(int [] arr, boolean [] visited, int nextIndex) {
        if (nextIndex == N) {
            for (int num : arr) {
                sb.append(num);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int k = 1; k <= N ; k++) {
            if (visited[k]) continue;
            visited[k] = true;
            arr[nextIndex] = k;
            fill(arr, visited, nextIndex + 1);
            visited[k] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        int [] arr = new int [N];
        boolean [] visited = new boolean[N + 1];
        
        fill(arr, visited, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}