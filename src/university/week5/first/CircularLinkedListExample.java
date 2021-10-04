package university.week5.first;

class ListNode {
    private String data;
    public ListNode link;

    public ListNode() {
            this.data = null;
            this.link = null;
            }

    public ListNode(String data) {
            this.data = data;
            this.link = null;
            }

    public ListNode(String data, ListNode link) {
            this.data = data;
            this.link = link;
            }

    public String getData() {return this.data;}
}

class CircularLinkedList {
    private ListNode head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void insertMiddleNode(ListNode pre, String data) {
        if (pre.link == head) {
            insertLastNode(data);
        } else {
            ListNode newNode = new ListNode(data);
            newNode.link = pre.link;
            pre.link = newNode;
        }
    }

    public void insertLastNode(String data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            this.head = newNode;
            newNode.link = newNode;
        } else {
            ListNode temp = head;
            while (temp.link != head) temp = temp.link;
            temp.link = newNode;
            newNode.link = head;
        }
    }

//    public void deleteMiddleNode(String data) {
//        ListNode pre, temp;
//        if (head == null) {
//            return;
//        }
//        pre = head;
//        temp = head.link;
//        while (temp.link != null) {
//            if (data.equals(temp.getData())) {
//                pre.link = temp.link;
//                return;
//            } else {
//                pre = temp;
//                temp = pre.link;
//            }
//        }
//        if (data.equals(temp.getData())) {
//            pre.link = null;
//        }
//    }

    public void deleteLastNode() {
        ListNode pre, temp;
        if (head == null) return;
        if (head.link == head) {
            head = null;
        } else {
            pre = head;
            temp = head.link;
            do {
                pre = temp;
                temp = pre.link;
            } while (temp.link != this.head);
            pre.link = head;
        }
    }

    public ListNode searchNode(String data) {
        ListNode temp = head;
        do {
            if (data.equals(temp.getData())) {
                return temp;
            } else {
                temp = temp.link;
            }
        } while (temp != head);
        temp = null;
        return temp;
    }

//    public void reverseList() {
//        ListNode next = head;
//        ListNode current = null;
//        ListNode pre = null;
//
//        while (next != null) {
//            pre = current;
//            current = next;
//            next = next.link;
//            current.link = pre;
//        }
//        head = current;
//    }

    public void printList() {
        ListNode temp = head;
        System.out.print("L = (");
        do {
            System.out.print(temp.getData());
            temp = temp.link;
            if (temp != head) {
                System.out.print(", ");
            }
        } while (temp != head);
        System.out.println(")");
    }
}

public class CircularLinkedListExample {
    public static void main(String[] args) {
        CircularLinkedList L = new CircularLinkedList();
        System.out.println("(1) 공백 리스트에 노드 3개 삽입");
        L.insertLastNode("월");
        L.insertLastNode("수");
        L.insertLastNode("일");
        L.printList();

        System.out.println("(2) 수 노드 뒤에 금 노드 삽입");
        ListNode pre = L.searchNode("수");
        if (pre == null) {
            System.out.println("검색 실패 찾는 데이터 없음");
        } else {
            L.insertMiddleNode(pre, "금");
            L.printList();
        }

        System.out.println("(3) 없는 데이터가 있다고 가정할 시 예외처리");
        ListNode pre2 = L.searchNode("값은 없습니당.");
        if (pre2 == null) {
            System.out.println("검색 실패 찾는 데이터 없음");
        } else {
            L.insertMiddleNode(pre, "금");
            L.printList();
        }

//        System.out.println("(3) 노드 데이터 역순으로 바꿔서 출력");
//        L.reverseList();
//        L.printList();

        System.out.println("(4) 마지막 노드 삭제하기");
        L.deleteLastNode();
        L.printList();

//        System.out.println("(5) 중간에 위치한 금노드 삭제");
//        L.deleteMiddleNode("금");
//        L.printList();

        System.out.println("(5) insertMiddleNode 마지막 데이터일시 예외처리");
        ListNode pre3 = L.searchNode("금");
        L.insertMiddleNode(pre3, "테스트");
        L.printList();
    }
}
