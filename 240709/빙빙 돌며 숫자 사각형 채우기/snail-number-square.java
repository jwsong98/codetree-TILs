import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dr = {0, +1, 0 ,-1};
    static int [] dc = {+1, 0, -1 ,0};

    public static void main(String[] args) throws Exception{
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nm.nextToken()), M = Integer.parseInt(nm.nextToken());
        int [][] answer = new int[N][M];
        int step = N * M;

        for (int t = 1, d = 0, r = 0, c = 0 ; t <= step ; t++) {
            answer[r][c] = t;

            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || answer[nr][nc] != 0) {
                d = (d + 1) % 4;

                nr = r + dr[d];
                nc = c + dc[d];
            }
            r = nr;
            c = nc;
        }
        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < M ; c++) {
                sb.append(answer[r][c]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}