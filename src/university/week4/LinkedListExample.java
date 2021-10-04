package university.week4;

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

    public String getData() {
        return this.data;
    }
}

class LinkedList {
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void insertMiddleNode(ListNode pre, String data) {
        ListNode newNode = new ListNode(data);
        newNode.link = pre.link;
        pre.link = newNode;
    }

    public void insertLastNode(String data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            this.head = newNode;
        } else {
            ListNode temp = head;
            while (temp.link != null) temp = temp.link;
            temp.link = newNode;
        }
    }

    public void deleteMiddleNode(String data) {
        ListNode pre, temp;
        if (head == null) {
            return;
        }
        pre = head;
        temp = head.link;
        while (temp.link != null) {
            if (data.equals(temp.getData())) {
                pre.link = temp.link;
                return;
            } else {
                pre = temp;
                temp = pre.link;
            }
        }
        if (data.equals(temp.getData())) {
            pre.link = null;
        }
    }

    public void deleteLastNode() {
        ListNode pre, temp;
        if (head == null) return;
        if (head.link == null) {
            head = null;
        } else {
            pre = head;
            temp = head.link;
            while (temp.link != null) {
                pre = temp;
                temp = pre.link;
            }
            pre.link = null;
        }
    }

    public ListNode searchNode(String data) {
        ListNode temp = this.head;
        while (temp != null) {
            if (data.equals(temp.getData())) {
                return temp;
            } else {
                temp = temp.link;
            }
        }
        return temp;
    }

    public void reverseList() {
        ListNode next = head;
        ListNode current = null;
        ListNode pre = null;

        while (next != null) {
            pre = current;
            current = next;
            next = next.link;
            current.link = pre;
        }
        head = current;
    }

    public void printList() {
        ListNode temp = this.head;
        System.out.print("L = (");
        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.link;
            if (temp != null) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList L = new LinkedList();
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

        System.out.println("(3) 노드 데이터 역순으로 바꿔서 출력");
        L.reverseList();
        L.printList();

        System.out.println("(4) 마지막 노드 삭제하기");
        L.deleteLastNode();
        L.printList();

        System.out.println("(5) 중간에 위치한 금노드 삭제");
        L.deleteMiddleNode("금");
        L.printList();
    }
}
