import java.util.Scanner;

public class Practice4 {
    // q7
    static void printSumOf(int n) {
        int result = 1;

        if (n < 1) {
            System.out.println("1이상 입력해주세요.");
        }
        else {
            System.out.print("1");
            for (int i = 2; i <= n; i++) {
                result += i;
                System.out.printf(" + %d", i);
            }
            System.out.println(" = " + result);
        }
    }

    // q8 가우스 덧셈
    static int gaussAddition(int n) {
        int result = (1 + n) * (n / 2);

        // 만약 n이 홀수면 중간값인 나머지 하나를 result에 더해줌
        if (n % 2 != 0) {
            result += (n + 1) / 2;
        }

        return result;
    }

    // q9 a ~ b까지의 합 구하는 함수
    static int sumOf(int a, int b) {
        if (a > b) {
            int changeInt = a;
            a = b;
            b = changeInt;
        }
        int result = 0;

        for (int i = a; i <= b; i++) {
            result += i;
        }

        return result;
    }

    public static void main(String[] args) {
        printSumOf(7);
        System.out.println("가우스 덧셈(1~10) = " + gaussAddition(10));
        System.out.printf("%d ~ %d의 덧셈 = %d, %d ~ %d의 덧셈 = %d\n", 3, 5, sumOf(3, 5), 6, 4, sumOf(6, 4));
    }
}
