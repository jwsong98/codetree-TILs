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

    static int [] dr = {+1, +2, +2, +1, -1, -2, -2, -1};
    static int [] dc = {+2, +1, -1, -2, -2, -1, +1, +2};

    static int N;
    public static void main(String[] args) throws Exception {
        Queue<Pos> q = new LinkedList<Pos>();
        N = Integer.parseInt(br.readLine());

        int [][] step = new int[N][N];
        for (int i = 0 ; i < N ; i++) {
            Arrays.fill(step[i], -1);
        }

        StringTokenizer SE = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(SE.nextToken()) - 1;
        int sc = Integer.parseInt(SE.nextToken()) - 1;
        int er = Integer.parseInt(SE.nextToken()) - 1;
        int ec = Integer.parseInt(SE.nextToken()) - 1;

        q.offer(new Pos(sr, sc));
        step[sr][sc] = 0;
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0 ; d < 8 ; d++) {
                int nr = cur.r + dr[d], nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || step[nr][nc] != -1) {
                    continue;
                }
                step[nr][nc] = step[cur.r][cur.c] + 1;
                q.offer(new Pos(nr, nc)); 

                if (nr == er && nc == ec) {
                    break;
                }
            }
        }
        sb.append(step[er][ec]);
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}