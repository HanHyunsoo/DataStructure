package assignment;

/** 두 다항식이 주어지면 더한 다음 출력하는 프로그램을 작성하시오.
    2x^2 + 3x와 x^3 + 3가 주어지면 x^3 + 2x^2 + 3x + 3을 출력
    최대 19차 다항식까지 주어질 수 있다.
 */

class Polynomial {
    private int degree;
    private int[] coef = new int[20];

    Polynomial(int degree, int[] coef) {
        this.degree = degree;
        for (int i = 0; i <= this.degree; i++) {
            int temp = this.degree - i;
            this.coef[temp] = coef[i];
        }
    }

    Polynomial(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return this.degree;
    }

    public int getCoef(int i) {
        return this.coef[i];
    }

    public void setCoef(int i, int coef) {
        this.coef[i] = coef;
    }

    public void printPoly() {
        for (int i = this.degree; i >= 0; i--) {
            System.out.printf("%2dx^%d", this.coef[i], i);
        }
        System.out.println();
    }
}

public class PolynomialExample1 {
    static Polynomial addPoly(Polynomial A, Polynomial B) {
        int degree_A = A.getDegree();
        int degree_B = B.getDegree();
        int degree_C = Math.max(degree_A, degree_B);

        Polynomial C = new Polynomial(degree_C);

        for (int i = 0; i <= degree_C; i++) {
            C.setCoef(i, A.getCoef(i) + B.getCoef(i));
        }

        return C;
    }

    public static void main(String[] args) {
        // 4x^3 + 3x^2 + 5x^1 + 0x^0
        int[] a = new int[]{4, 3, 5, 0};
        Polynomial A = new Polynomial(3, a);
        // 3x^4 + 1x^3 + 0x^2 + 2x^1 + 1x^0
        int[] b = new int[]{3, 1, 0, 2, 1};
        Polynomial B = new Polynomial(4, b);
        // 3x^4 + 5x^3 + 3x^2 + 7x^1 + 1x^0
        Polynomial C = addPoly(A, B);
        System.out.print("A(x)=");
        A.printPoly();
        System.out.print("B(x)=");
        B.printPoly();
        System.out.print("C(x)=");
        C.printPoly();
    }
}