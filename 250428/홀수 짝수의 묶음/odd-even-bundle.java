import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        int even = 0, odd = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] % 2 == 0) {
                even += 1;
            } 
        }
        odd = N - even;

        /*
            남는 게 문제임. 
                even이 남는건 문제 X 무시 가능
            
            odd 후 even 해야 하는데 못 만드는 경우 -> even 없고 odd도 남은 게 3 * 홀수 + 1 개임.
                이러면? odd 만들 때 2개 더 땡겨 쓰면?
                3 * x + 1 - 2 = 3 * x - 1
            even 후 odd 해야 하는데 못 만드는 경우 -> 
                odd 없는 경우 무조건 
        */
        int answer = 0;
        while ((odd + even) > 0) {
            if (answer % 2 == 0) {
                if (even > 0) {
                    even -= 1;
                    answer += 1;
                } else if (odd >= 2) {
                    odd -= 2;
                    answer += 1;
                } else {
                    // 홀수 하나 남아서 안되는 경우임
                    // [짝수] - [홀수] - (짝수)
                    // 그럼? 뒤에 홀수 만든거랑 합쳐서 짝수에 병합하면 개굿
                    answer -= 1;
                    break;
                }
            } else {
                if (odd > 0) {
                    odd -= 1;
                    answer += 1;
                } else {
                    // [짝수] - (홀수)
                    // 짝수 밖에 안남았음.... 쩜쩜쩜 그냥 바로 뒤 짝수에 병합하면 개굿
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}