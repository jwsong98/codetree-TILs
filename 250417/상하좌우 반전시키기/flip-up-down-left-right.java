import java.util.*;

public class Main {
    static int [] dr = {0, +1, -1, 0, 0};
    static int [] dc = {0, 0, 0, +1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int zero = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 0) {
                    zero += 1;
                }
            }
        }

        int answer = 0;

        while (zero != 0) {
            answer += 1;
            int row = -1, col = -1, score = 0;
            for (int r = 0 ; r < n ; r++) {
                for (int c = 0 ; c < n ;c++) {
                    int tempScore = 0;

                    for (int d = 0 ; d < 5 ; d++) {
                        int nr = r + dr[d], nc = c + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                            continue;
                        }
                        if (arr[nr][nc] == 0) {
                            tempScore += 1;
                        } else {
                            tempScore -= 1;
                        }
                    }
                    if (tempScore > score) {
                        score = tempScore;
                        row = r;
                        col = c;
                    }
                }
            }
            for (int d = 0 ; d < 5 ; d++) {
                int nr = row + dr[d], nc = col + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (arr[nr][nc] == 0) {
                    zero -= 1;
                } else {
                    zero += 1;
                }
                arr[nr][nc] = 1 - arr[nr][nc];
            }
        }
        System.out.print(answer);
        // Please write your code here.
    }
}
/**
0101
0101
0101
1111
**/