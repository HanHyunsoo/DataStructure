// p19

public class Practice1 {
    // q1
    static int max4(int a, int b, int c, int d) {
        int compare1, compare2;

        compare1 = (a > b) ? a : b;
        compare2 = (c > d) ? c : d;

        return (compare1 > compare2) ? compare1 : compare2;
    }
    // q2
    static int min3(int a, int b, int c) {
        int compare = (a > b) ? b : a;

        return (compare > c)? c : compare;
    }
    // q3
    static int min4(int a, int b, int c, int d) {
        int compare1, compare2;

        compare1 = (a > b) ? b : a;
        compare2 = (c > d) ? d : c;

        return (compare1 > compare2) ? compare2 : compare1;
    }

    public static void main(String[] args) {
        System.out.println(max4(1, 2, 3, 4));
        System.out.println(min3(1, 2, 3));
        System.out.println(min4(5, 4, 6, 7));
    }
}
