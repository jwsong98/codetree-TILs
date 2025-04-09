import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int [] dr = { 0, +1, +1, +1,  0, -1, -1, -1};
    static int [] dc = {+1, +1,  0, -1, -1, -1,  0, +1};

    public static void main(String[] args) {
        int answer = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = "LEE";
        char [][] arr = new char [n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }

        for (int r = 0 ; r < n ; r++) {
            for (int c = 0 ; c < m ; c++) {
                char ch = arr[r][c];
                if (ch != str.charAt(0)) {
                    continue;
                }
                for (int d = 0 ; d < 8 ; d++) {
                    int i = 1;
                    for (; i < str.length(); i++) {
                        int nr = r + dr[d] * i, nc = c + dc[d] * i;

                        if (nr < 0 || nc < 0 || nr >= n || nc >= m) break;
                        char nxt = arr[nr][nc];
                        if (nxt != str.charAt(i)) {
                            break;
                        }
                    }
                    if (i == str.length()) {
                        answer += 1;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}