import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dr = {-1, 0, 1 ,0};
    static int [] dc = {0, +1, 0, -1};
    public static void main(String[] args) throws Exception{
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nm.nextToken());
        int M = Integer.parseInt(nm.nextToken());
        int [][] map = new int[N][N];

        for (int i = 0 ; i < M ; i++) {
            StringTokenizer rc = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(rc.nextToken()) - 1;
            int c = Integer.parseInt(rc.nextToken()) - 1;
            map[r][c] = 1;

            int count = 0;
            for (int d = 0; d < 4 ; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }
                if (map[nr][nc] == 1) 
                    count += 1;
            }
            sb.append(count == 3 ? 1 : 0);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}