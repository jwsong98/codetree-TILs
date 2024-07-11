import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dr = {-1, +1, 0, 0};
    static int [] dc = {0, 0, -1, +1};

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        StringTokenizer nrc = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nrc.nextToken());
        int R = Integer.parseInt(nrc.nextToken()) - 1;
        int C = Integer.parseInt(nrc.nextToken()) - 1;
        int [][] map = new int[N][N];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer tkn = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                map[r][c] = Integer.parseInt(tkn.nextToken());
            }
        }
        for (int r = R, c = C;;) {
            sb.append(map[r][c]);
            sb.append(" ");

            int nd = -1;
            for (int d = 0 ; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0  || nr >= N || nc < 0 || nc >= N) {
                    continue;
                } 
                if (map[nr][nc] > map[r][c]) {
                    nd = d;
                    break;
                }
            }
            if (nd == -1)
                break;
            r = r + dr[nd];
            c = c + dc[nd];
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}