import java.util.Scanner;

public class Main {
    static int [] dr = {0, +1 ,+1, -1};
    static int [] dc = {+1, 0, +1, +1};

    static int win = 0;
    static int row = 0;
    static int col = 0;

    static int [][] visited = new int [19][19];

    static int dfs(int [][] arr, int sign, int r, int c, int dir, int num) {
        if (r >= 19 || c >= 19 || r < 0 || c < 0) {
            return 0;
        }
        if ((visited[r][c] & (1 << dir)) == 1) {
            return 0;
        }
        if (arr[r][c] == sign) {
            visited[r][c] |= (1 << dir);
            if (num == 4) {
                return 1;
            }
            int res = dfs(arr, sign, r + dr[dir], c + dc[dir], dir, num + 1);
            if (res == 1) {
                if (num == 2) {
                    win = sign;
                    row = r + 1;
                    col = c + 1;
                }
                return 1;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean finish = false;
        for (int r = 0 ; r < 19 && !finish ; r++) {
            for (int c = 0; c < 19 && !finish ; c++) {
                int sign = arr[r][c];
                if (sign == 0) continue;

                for (int d = 0; d < 4 ; d++) {
                    if (dfs(arr, sign, r, c, d, 0) == 1) {
                        finish = true;
                        break;
                    }
                }
            }
        }
        System.out.println(win);
        if (finish) {
            System.out.printf("%d %d", row, col);
        }
    }
}