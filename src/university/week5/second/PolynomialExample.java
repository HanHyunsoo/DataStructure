package university.week5.second;

import java.text.DecimalFormat;

class ListNode {
    private Float coef;
    private Integer expo;
    public ListNode link;

    public ListNode() {
        this.coef = null;
        this.expo = null;
        this.link = null;
    }

    public ListNode(float coef, int expo) {
        this.coef = coef;
        this.expo = expo;
        this.link = null;
    }

    public float getCoef() {
        return coef;
    }

    public int getExpo() {
        return expo;
    }

    DecimalFormat df = new DecimalFormat("#.###");
    public String toString() {
        String result = "";
        if (coef == 0) {
            return result;
        } else {
            result += String.format("%sx^%d", df.format(this.coef), this.expo);
        }
        if (coef < 0) {
            return "(" + result + ")";
        }

        return result;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode last;

    public ListNode getHead() {
        return head;
    }

    public LinkedList() {
        this.head = null;
        this.last = null;
    }

    public void insertLastNode(ListNode node) {
        if (head == null && last == null) {
            this.head = node;
        } else {
            this.last.link = node;
        }
        this.last = node;
    }

    public void printList() {
        if (head == null && last == null) {
            System.out.println("이 리스트는 존재하지 않습니다.");
            return;
        }

        ListNode temp = head;
        String result = "";
        while (temp != null) {
            result += temp.toString();
            if (temp.link != null) {
                result += " + ";
            }
            temp = temp.link;
        }


        System.out.println(result);
    }
}

class PolynomialExample {
    public static LinkedList addPoly(LinkedList A, LinkedList B) {
        ListNode headA = A.getHead();
        ListNode headB = B.getHead();
        LinkedList C = new LinkedList();
        float sum;

        while (headA != null && headB != null) {
            if (headA.getExpo() == headB.getExpo()) {
                sum = headA.getCoef() + headB.getCoef();
                C.insertLastNode(new ListNode(sum, headA.getExpo()));
                headA = headA.link;
                headB = headB.link;
            } else if (headA.getExpo() > headB.getExpo()) {
                C.insertLastNode(headA);
                headA = headA.link;
            } else {
                C.insertLastNode(headB);
                headB = headB.link;
            }
        }

        while (headA != null) {
            C.insertLastNode(headA);
            headA = headA.link;
        }

        while (headB != null) {
            C.insertLastNode(headB);
            headB = headB.link;
        }

        return C;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(-3, 2);
        ListNode b = new ListNode(3, 1);
        ListNode c = new ListNode(3, 0);
        ListNode g = new ListNode(3, -1);

        LinkedList A = new LinkedList();
        A.insertLastNode(a);
        A.insertLastNode(b);
        A.insertLastNode(c);
        A.insertLastNode(g);

        ListNode d = new ListNode(2, 2);
        LinkedList B = new LinkedList();
        B.insertLastNode(d);

        LinkedList C = addPoly(A, B);
        C.printList();
    }
}