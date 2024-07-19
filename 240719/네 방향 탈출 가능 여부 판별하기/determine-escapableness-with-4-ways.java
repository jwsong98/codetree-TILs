import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

    static class Pos {
        int r;
        int c;
        Pos (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static final int[] dr = {+1, 0, -1, 0};
    static final int[] dc = {0, +1, 0, -1};

    public static void main(String[] args) throws Exception {
        StringTokenizer NM = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NM.nextToken());
        int M = Integer.parseInt(NM.nextToken());
        
        int [][] map = new int[N][M];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < M ; c++) {
                map[r][c] = Integer.parseInt(row.nextToken());
            }
        }
       	
        Queue<Pos> q = new ArrayDeque<>();
        boolean [][] visited = new boolean[N][N];
        boolean success = true;

        q.add(new Pos(0, 0));
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (cur.r == N - 1 && cur.c == M - 1) {
                success = true;
                break;
            }

            for (int d = 0 ; d < 4 ; d++) {
                int nr = cur.r + dr[d], nc = cur.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                } 
                visited[nr][nc] = true;
                q.offer(new Pos(nr, nc));
            }
        }
        sb.append(success? 1: 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}