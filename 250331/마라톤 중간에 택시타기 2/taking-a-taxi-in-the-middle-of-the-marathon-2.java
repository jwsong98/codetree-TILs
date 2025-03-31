import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] sum = new int [n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // sum[i]: [i, n - 1]
        for (int i = n - 2; i >= 0 ; i--) {
            sum[i] = (sum[i + 1] + Math.abs(x[i + 1] - x[i]) + Math.abs(y[i + 1] - y[i]));
        }

        int answer = Integer.MAX_VALUE;
        for (int ex = 1; ex < n - 1; ex++) {
            // [0, ex - 1] + [ex + 1, n - 1] + dist(ex - 1, ex + 1)
            int newValue = (sum[0] - sum[ex - 1]) + sum[ex + 1] + Math.abs(x[ex - 1] - x[ex + 1]) + Math.abs(y[ex - 1] - y[ex + 1]);
            answer = Math.min(answer, newValue);
        }
        System.out.print(answer);
    }
}