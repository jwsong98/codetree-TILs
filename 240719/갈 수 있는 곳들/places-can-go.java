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
        StringTokenizer NK = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(NK.nextToken());
        int K = Integer.parseInt(NK.nextToken());
        
        int [][] map = new int[N][N];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                map[r][c] = Integer.parseInt(row.nextToken());
            }
        }
       	
        Queue<Pos> q = new ArrayDeque<>();
        boolean [][] visited = new boolean[N][N];
        int count = 0;

        for (int k = 0 ; k < K ; k++) {
            StringTokenizer pos = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(pos.nextToken()) - 1;
            int c = Integer.parseInt(pos.nextToken()) - 1; 
            if (map[r][c] == 0) {
                q.add(new Pos(r, c));
                visited[r][c] = true;
                count += 1;
            }
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int d = 0 ; d < 4 ; d++) {
                int nr = cur.r + dr[d], nc = cur.c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 1) {
                    continue;
                }
                count += 1; 
                visited[nr][nc] = true;
                q.offer(new Pos(nr, nc));
            }
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}