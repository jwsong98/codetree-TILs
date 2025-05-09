import java.util.*;

public class Main {

    static int find(int [] arr, int left, int right, int target) {
        int l = left, r = right;

        int index = -1;
        while (l <= r) {
            int m = (l + r) / 2;

            if (target <= arr[m]) {
                index = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return index;
    }

    static boolean test(int [] arr, int bar) {
        boolean [] visited = new boolean [arr.length];

        int pair = 0;
        for (int i = 0 ; i < arr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int search = find(arr, i + 1, arr.length - 1, arr[i] + bar);
    
            if (search == -1) {
                return -1;
            }

            int j = search;
            for (; j < arr.length; j++) {
                if (visited[j]) {
                    continue;
                }
                visited[j] = true;
                break;
            }

            if (j == arr.length) {
                if (bar == 2_500_000_00) {
                    System.out.print("Not visited: ");
                    int count = 0;
                    for (int k = search; k < arr.length; k++) {
                        if (!visited[k] && count < 10) {
                            System.out.printf("%d ", k);
                            count += 1;
                        }
                    }
                    System.out.println();
                }
                // 23560
                System.out.printf("%d %d (%d %d) %d %d\n", i, search, arr[search - 1], arr[search], arr[i] + bar, arr[arr.length - 1]);
                return false;
            }
            pair += 1;
        }

        if (pair != (arr.length / 2)) {
            for (int i = 0 ; i < arr.length ; i++) {
                if (!visited[i]) {
                    System.out.printf("%d(%d) ", arr[i], i);
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);


        int answer = 0;
        int l = 1, r = 1_000_000_000;
        while (l <= r) {
            int m = (l + r) / 2;

            boolean res = test(arr, m);
            if (res) {
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.print(answer);
    }
}
// 495032915
// 500000000