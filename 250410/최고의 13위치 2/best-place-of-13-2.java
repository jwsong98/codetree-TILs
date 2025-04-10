import java.util.*;

public class Main {
    static int answer = Integer.MIN_VALUE;

    static void getNum(int [][] arr, int [][] state, int sum, int num) {
        if (num == 2) {
            answer = Math.max(answer, sum);
            return ;
        }

        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr[0].length - 2; j++) {
                int step = 0;
                for (; step < 3; step++) {
                    final int nr = i + 0 * step, nc = j + 1 * step;
                    
                    if ((state[nr][nc] & (1 << 0)) != 0) {
                        break;
                    }
                }
                if (step == 3) {
                    int add = 0;
                    for (int k = 0; k < 3 ; k++) {
                        final int nr = i + 0 * k, nc = j + 1 * k;
                        add += arr[nr][nc];
                        state[nr][nc] |= (1 << 0);
                    }
                    getNum(arr, state, sum + add, num + 1);
                    for (int k = 0; k < 3 ; k++) {
                        final int nr = i + 0 * k, nc = j + 1 * k;
                        state[nr][nc] &= (~(1 << 0));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int [n][n];
        int [][] state = new int [n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        getNum(arr, state, 0, 0);
        System.out.print(answer);
    }
}