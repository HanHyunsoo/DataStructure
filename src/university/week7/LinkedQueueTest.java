package university.week7;

class Node {
    char data;
    Node link;
}

class LinkedQueue implements Queue {

    Node front;
    Node rear;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("이 리스트는 비어있습니다.");
        } else {
            Node temp = front;
            System.out.print("Linked Queue = (");
            while (temp != null) {
                System.out.print(temp.data);
                temp = temp.link;
                if (temp != null) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }

    @Override
    public boolean isEmpty() {
        return this.front == null;
    }

    @Override
    public void enQueue(char item) {
        Node node = new Node();
        node.data = item;
        node.link = null;

        if (isEmpty()) {
            this.front = node;
            this.rear = node;
        } else {
            rear.link = node;
            this.rear = node;
        }
        System.out.println(item + " <- 삽입 완료");
    }

    @Override
    public char deQueue() {
        if (isEmpty()) {
            System.out.println("이 큐는 비어있습니다.");
            return 0;
        } else {
            char item = front.data;
            this.front = front.link;
            if (front == null) {
                this.rear = null;
            }
            return item;
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("이 큐는 비어있습니다.");
        } else {
            this.front = front.link;
            if (front == null) {
                this.rear = null;
            }
        }
    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("이 큐는 비어있습니다.");
            return 0;
        } else {
            return front.data;
        }
    }
}

public class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue Q = new LinkedQueue();
        Q.enQueue('A');
        Q.printQueue();
        Q.enQueue('B');
        Q.printQueue();
        Q.enQueue('C');
        Q.printQueue();
        Q.enQueue('D');
        Q.printQueue();
        char peekedItem = Q.peek();
        if (peekedItem != 0)
            System.out.println("peeked Item : " + peekedItem);
        Q.printQueue();
        char dequeuedItem = Q.deQueue();
        if (dequeuedItem != 0)
            System.out.println("dequeued Item : " + dequeuedItem);
        Q.printQueue();
    }
}
