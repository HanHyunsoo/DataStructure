import java.util.Scanner;

public class Practice3 {
    // q5
    // or 연산으로 이미 값을 비교한것을 또 비교하기때문에 Practice2.med3 보다 처리 속도가 느리다.
    static int med3(int a, int b, int c) {
        if ((b >= a && c <= a) || (b <= a && c >= a)) {
            return a;
        }
        else if ((a > b && c < b) || (a < b && c > b)) {
            return b;
        }
        else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;

        System.out.print("첫번째 수: ");
        a = sc.nextInt();

        System.out.print("두번째 수: ");
        b = sc.nextInt();

        System.out.print("세번째 수: ");
        c = sc.nextInt();
        sc.close();

        System.out.println("중간값 : " + med3(a, b, c) );
    }
}
