import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dr = {0, -1, 0 ,+1};
    static int [] dc = {+1, 0, -1 ,0};

    static class Pos {
        int r;
        int c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int [][] map = new int[4][4];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer rowsNum = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(rowsNum.nextToken());
            }
        }
        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < N ; c++) {
                int count = 0;
                for (int d = 0 ; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }
                    if (map[nr][nc] == 1) {
                        count += 1;
                    }
                }
                if (count >= 3) {
                    ans += 1;
                }
            }
        }
        
        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}