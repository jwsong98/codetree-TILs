import java.util.*;

public class Main {

    static int find(int [] arr, boolean [] visited, int left, int right, int target) {
        int l = left, r = right;

        int index = -1;
        while (l <= r) {
            int m = (l + r) / 2;

            if (target <= arr[m]) {
                if (index == -1 || index > m) {
                    index = m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return index;
    }

    static int test(int [] arr, int bar) {
        int actual = Integer.MAX_VALUE;
        boolean [] visited = new boolean [arr.length];
        int pair = 0;

        for (int i = 0 ; i < arr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            boolean matched = false;
            int search = find(arr, visited, i + 1, arr.length - 1, arr[i] + bar);
            if (search == -1) {
                return -1;
            }
            for (int j = search; j < arr.length; j++) {
                if (visited[j]) {
                    continue;
                }
                visited[j] = true;
                matched = true;
                actual = Math.min(actual, arr[j] - arr[i]);
                break;
            }
            if (!matched) return -1;
            pair += 1;
        }

        if (pair != (arr.length / 2)) {
            return -1;
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
        int l = 1, r = 1_000_000_000;
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
