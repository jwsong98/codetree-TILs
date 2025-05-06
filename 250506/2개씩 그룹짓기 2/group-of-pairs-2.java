import java.util.*;

public class Main {
    static int test(int [] arr, int bar) {
        int actual = Integer.MAX_VALUE;
        boolean [] visited = new boolean [arr.length];
        for (int i = 0 ; i < arr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            boolean found = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (visited[j]) continue;

                int diff = arr[j] - arr[i];
                if (bar <= diff) {
                    actual = Math.min(actual, diff);
                    visited[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) return -1;
        }
        return actual;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        // for (int i = 0 ; i < arr.length; i++) {
        //     System.out.printf("%d ", arr[i]);
        // }
        // System.out.println();

        int answer = 0;
        int l = 1, r = 100_000;
        while (l <= r) {
            int m = (l + r) / 2;

            int temp = test(arr, m);
            // System.out.printf("%d %d\n", m, temp);
            if (temp == -1) {
                r = m - 1;
            } else {
                l = m + 1;
                answer = Math.max(answer, temp);
            }
        }
        System.out.print(answer);
    }
}