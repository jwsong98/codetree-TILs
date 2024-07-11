import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int [] dr = {-1, +1, 0, 0};
    static int [] dc = {0, 0, -1, +1};

    static class Node {
        int r;
        int c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        StringTokenizer nmt = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nmt.nextToken());
        int M = Integer.parseInt(nmt.nextToken());
        int T = Integer.parseInt(nmt.nextToken());

        int [][] map = new int [N][N];
        int [][] count = new int [N][N];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N; c++) {
                map[r][c] = Integer.parseInt(nums.nextToken());
            }
        }
        
        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0 ; i < M ; i++) {
            StringTokenizer rc = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(rc.nextToken()) - 1;
            int c = Integer.parseInt(rc.nextToken()) - 1;
            
            count[r][c] = 1;
            q.offer(new Node(r, c));
        }

        for (int t = 0 ; t < T ; t++) {
            int [][] temp = new int [N][N];

            while(!q.isEmpty()) {
                Node pos = q.poll();
                int nd = -1, maxV = -1;
                for (int d = 0 ; d < 4 ;d++) {
                    int nr = pos.r + dr[d], nc = pos.c + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N ) {
                        continue;
                    }
                    if (map[pos.r][pos.c] < map[nr][nc]) {
                        if (maxV < map[nr][nc]) {
                            maxV = map[nr][nc];
                            nd = d;                            
                        }
                    }
                }
                if (nd != -1) {
                    temp[pos.r + dr[nd]][pos.c + dc[nd]] += 1;
                }
            }

            for (int r = 0 ; r < N ; r++) {
                for (int c = 0 ; c < N; c++) {
                    if (temp[r][c] >= 2) {
                        temp[r][c] = 0;
                    } else if (temp[r][c] == 1) {
                        q.offer(new Node(r, c));
                    }
                    count[r][c] = temp[r][c];
                }
            }
        }
        sb.append(q.size());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}