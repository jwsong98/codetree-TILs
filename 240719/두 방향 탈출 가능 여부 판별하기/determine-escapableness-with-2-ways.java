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
    
    static final int[] dr = {+1, 0};
    static final int[] dc = {0, +1};

    public static void main(String[] args) throws Exception {
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nm.nextToken()) - 1;
        int M = Integer.parseInt(nm.nextToken()) - 1;
        int [][] map = new int[N][M];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < M ; c++) {
                map[r][c] = Integer.parseInt(row.nextToken());
            }
        }
       	
        Stack<Pos> stk = new Stack<>();
        boolean [][] visited = new boolean[N][M];
        boolean success = false;

        if (map[0][0] == 1) {
            stk.add(new Pos(0, 0));
            visited[0][0] = true;
        }
        while (!stk.isEmpty()) {
            Pos cur = stk.pop();

            if (cur.r == N - 1 && cur.c == M - 1) {
                success = true;
                break;
            }
            for (int d = 0 ; d < 2 ; d++) {
                int nr = cur.r + dr[d], nc = cur.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                } 
                visited[nr][nc] = true;
                stk.push(new Pos(nr, nc));
            }
        }
        sb.append(success?1:0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}