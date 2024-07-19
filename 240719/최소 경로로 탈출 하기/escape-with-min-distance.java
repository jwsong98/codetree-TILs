import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static class Pos {
        int r;
        int c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int [] dr = {+1, 0, -1, 0};
    static int [] dc = {0, +1, 0, -1};

    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        Queue<Pos> q = new LinkedList<Pos>();
        StringTokenizer NM = new StringTokenizer(br.readLine());
        N = Integer.parseInt(NM.nextToken());
        M = Integer.parseInt(NM.nextToken());

        int [][] map = new int[N][M];
        int [][] step = new int[N][M];
        for (int i = 0 ; i < N ; i++) {
            Arrays.fill(step[i], -1);
        }

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < M ; c++) {
                map[r][c] = Integer.parseInt(row.nextToken());
            }
        }
        q.offer(new Pos(0, 0));
        step[0][0] = 0;
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0 ; d < 4 ; d++) {
                int nr = cur.r + dr[d], nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || step[nr][nc] != -1 || map[nr][nc] == 0) {
                    continue;
                }
                step[nr][nc] = step[cur.r][cur.c] + 1;
                q.offer(new Pos(nr, nc)); 
            }
        }
        sb.append(step[N - 1][M - 1]);
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}