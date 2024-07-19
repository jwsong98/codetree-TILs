import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
    static int [] dr = {+1, 0, -1, 0};
    static int [] dc = {0, +1, 0, -1};
    static int N = 0;
    static int dfs(int r, int c, int id, int [][] field) {
        int count = 1;

        for (int d = 0 ; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || field[nr][nc] != id) {
                continue;
            }
            field[nr][nc] = -1;
            count += dfs(nr, nc, id, field);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int maxSize = 0, answer = 0;
        int [][] field = new int[N][N];
        for (int r = 0 ; r < N ; r++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                field[r][c] = Integer.parseInt(row.nextToken());
            }
        }

        for (int sr = 0; sr < N ; sr++) {
            for (int sc = 0 ; sc < N ; sc++) {
                if (field[sr][sc] != -1) {
                    int id = field[sr][sc];
                    field[sr][sc] = -1;
                    int count = dfs(sr, sc, id, field);
                    if (count >= 4) {
                        answer += 1;
                    }
                    maxSize = Math.max(maxSize, count);
                } 
            }
        }
        sb.append(String.format("%d %d", answer, maxSize));
	    bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}