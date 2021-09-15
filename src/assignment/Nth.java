package assignment;

import java.util.Arrays;

public class Nth {
    //    배열 만드는 함수
    static int[][] makeArray(int row, int column) {
        // resultArray 변수에 행이 row, 열이 column 만큼 2차원 배열을 선언
        int[][] resultArray = new int[row][column];
        // countNum은 n번째를 보여주기위한 변수
        int countNum = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                resultArray[i][j] = countNum;
                countNum++;
            }
        }

        return resultArray;
    }

    // 2차원 배열을 출력하는 함수
    static void showArray(int[][] array) {
        System.out.println("===================================");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("===================================");
    }

    public static void main(String[] args) {
        // Test#1

        // 행
        int m = 2;
        // 열
        int n = 4;

        // x 변수에 행 m, 열 n인 2차원 배열을 생성후 대입
        int[][] x = makeArray(m, n);
        showArray(x);

        int a = 1;
        int b = 0;
        // x[a][b](==x[1][0])의 값은 5
        System.out.printf("x[%d][%d]의 값은 %d\n", a, b, x[a][b]);

        // 행의크기 𝑴, 열의크기 𝑵 인데이터 𝑴×𝑵개가있다. 행을 우선하면 x[a][b]는 아래 공식으로 순서를 구할 수 있다.
        System.out.println((n * a) + (b + 1));

        // Test#2

        m = 5;
        n = 9;
        int[][] y = makeArray(m, n);
        showArray(y);

        a = 3;
        b = 6;
        System.out.printf("y[%d][%d]의 값은 %d\n", a, b, y[a][b]);
        /*
         설명 하자면 행 인덱스 a라면 a - 1 행까지는 전부 읽었다 행 하나의 열 값은 총 n만큼 있으므로 n * a로 a - 1행까지의 번째값을 구하고
         남은 값은 열값인데 열 인덱스 b라면 (b + 1)번째를 의미하니 (n * a)로 그 행을 열의 개수인 n과 인덱스 a를 곱한값과 (b + 1)를 더하여
         인덱스 행 a, 열 b가 있을때 a,b와 열의 개수 n을 이용하여 몇번째인지 알 수있다. 아래 공식을 적어놓겠습니다.

         (n * a) + (b + 1)
         조건 : a, b, m, n은 정수(int)
               m > a && n > b
        */
        System.out.println((n * a) + (b + 1));
    }
}
