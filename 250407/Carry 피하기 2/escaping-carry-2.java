import java.util.*;
public class Main {
    static int answer = Integer.MIN_VALUE;

    static void comb(int [] arr, int idx, int [] picked, int chosen) {
        if (chosen == 3) {
            int [] copyed = new int [3];
            for (int i = 0 ; i < 3; i++) {
                copyed[i] = picked[i];
            }

            for (int i = 0 ; i < 5; i++) {
                int term = 0;
                for (int j = 0 ; j < 3 ; j++) {
                    term += (copyed[j] % 10);
                    copyed[j] /= 10;
                }
                if (term / 10 != 0) {
                    return;
                }
            }

            int sum = 0;
            for (int i = 0 ; i < 3 ; i++) {
                sum += picked[i];
            }
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = idx ; i < arr.length; i++) {
            picked[chosen] = arr[i];
            comb(arr, i + 1, picked, chosen + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int [] picked = new int [3];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        comb(arr, 0, picked, 0);
        System.out.print(answer);
    }
}